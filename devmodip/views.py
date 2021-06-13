from django.shortcuts import render, redirect
from django.forms.models import model_to_dict
from .forms import *
from .forms import *
import json
from django.contrib.auth import login, logout
from django.contrib.auth.models import User
import locale
import random
from .models import *
from django.http import JsonResponse

locale.setlocale(locale.LC_ALL, "ru_RU")

def get_persondata(request):
    data = PersonData.objects.filter(owner=request.user).first()
    if not data:
        data = PersonData.objects.create(owner=request.user)
    return data

def get_dostizh(request):
    data = Portfolio.objects.filter(owner=request.user).first()
    if not data:
        data = Portfolio.objects.create(owner=request.user)
    return data

def get_plan(request):
    data = LearnPlan.objects.filter(owner=request.user).first()
    if not data:
        data = LearnPlan.objects.create(owner=request.user)
    return data


def main(request):
    return render(request, 'main.html')

def lk(request):
    data = get_persondata(request)
    dostizh = get_dostizh(request)
    plan = get_plan(request)
    return render(request, 'lk.html', {'data': data, 'dost': dostizh, 'plan':plan})

def about(request):
    return render(request, 'about.html')
def docs(request):
    return render(request, 'docs.html')


def test(request):
    return render(request, 'test.html')


def user_login(request):
    if request.method == 'POST':
        form = UserLoginForm(data=request.POST)
        if form.is_valid():
            user = form.get_user()
            login(request, user)
            return redirect('graph')
        else:
            return render(request, "login.html", {'form': form})
    else:
        form = UserLoginForm()
    return render(request, "login.html", {'form': form})


def user_logout(request):
    if request.user.is_authenticated:
        logout(request)
    return redirect('main')


def register(request):
    if request.method == 'POST':
        form = UserRegisterForm(data=request.POST)
        if form.is_valid():
            user = form.save(commit=False)
            user.set_password(form.cleaned_data['password1'])
            user.save()
            return redirect('graph')
        else:
            return render(request, "register.html", {'form': form})
    else:
        form = UserLoginForm()
    return render(request, "register.html", {'form': form})


def graph(request):

    if request.user.is_authenticated:
        persondata = get_persondata(request)
        form = CalcForm({'prof_predmet': persondata.prof_predmet, 'hobbi': persondata.hobbi, 'want_prof': persondata.want_prof, 'want_spec': persondata.want_spec})
    else:
        form =CalcForm()
    data = list()
    for item in Kurses.objects.all():
        data.append({
            'data': {'id': item.name, 'url': item.url,
                     'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})'}
        })
        if item.vid == 'Нео':
            for i in Kurses.objects.filter(vid='Про', category=item.category):
                data.append({
                    'data': {'id': item.name + '_' + i.name,
                             'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})',
                             'source': item.name, 'target': i.name}
                })
        elif item.vid == 'Биз':
            for i in Kurses.objects.filter(vid='Топ', category=item.category):
                data.append({
                    'data': {'id': item.name + '_' + i.name,
                             'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})',
                             'source': item.name, 'target': i.name}
                })
        if item.category == 'Программирование' or item.name.lower().find('python') != -1 or item.name.lower().find('разработчик') != -1 or item.name.lower().find('программист') != -1:
            for i in Spec.objects.all():
                if 'Математика' in i.ege.all() or 'Информатика и ИКТ' in i.ege.all():
                    data.append({
                        'data': {'id': item.name + '_' + i.name,
                                 'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})',
                                 'source': item.name, 'target': i.name}
                    })
        if item.category == 'Бизнес и управление' or item.name.lower().find('бизн') != -1 or item.name.lower().find('менедж') != -1:
            for i in Spec.objects.all():
                if 'Обществознание' in i.ege.all():
                    data.append({
                        'data': {'id': item.name + '_' + i.name,
                                 'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})',
                                 'source': item.name, 'target': i.name}
                    })
        if item.category == 'Дизайн и UX' or item.name.lower().find('диза') != -1 or item.name.lower().find('ui') != -1 or item.name.lower().find('ux') != -1:
            for i in Spec.objects.all():
                if 'Литература' in i.ege.all() or 'История' in i.ege.all():
                    data.append({
                        'data': {'id': item.name + '_' + i.name,
                                 'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})',
                                 'source': item.name, 'target': i.name}
                    })

    for item in Spec.objects.all():
        data.append({
            'data': {'id': item.name,'url':item.url,
                     'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})'}
        })
        for prof in item.prof.all():
            data.append({
                'data': {'id': item.name + '_' + prof.name,
                         'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})',
                         'source': item.name, 'target': prof.name}
            })
    for item in Profession.objects.all():
        data.append({
            'data': {'id': item.name, 'url':item.url,
                     'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})'}
        })
    return render(request, 'graph.html', {'data': data, 'form': form, 'spec':Spec.objects.all(), 'prof':Profession.objects.all(), 'ege':Ege.objects.all()})


def math(request):
    if request.method == 'POST':
        prof = list()
        spec = list()
        pred = list()
        special = list()
        ret_prof = list()
        for item in request.POST['want_prof[]']:
            prof.append(Profession.objects.get(pk=int(item)))
        for item in request.POST['want_spec[]']:
            spec.append(Spec.objects.get(pk=int(item)))
        for item in request.POST['pred[]']:
            pred.append(Ege.objects.get(id=int(item)).name)
        for item in spec:
            for i in pred:
                if not i.name in item.ege:
                    break
                special.append(item.name)
        for item in special:
            for i in item.prof:
                if i.name in prof:
                    ret_prof.append(i.name)
        data = {'ege': pred, 'spec': special, 'prof': ret_prof}
        return JsonResponse(data)

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
        form = CalcForm(
            {'prof_predmet': persondata.prof_predmet, 'hobbi': persondata.hobbi, 'want_prof': persondata.want_prof,
             'want_spec': persondata.want_spec})
    else:
        form = CalcForm()
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
        if item.category == 'Программирование' or item.name.lower().find('python') != -1 or item.name.lower().find(
                'разработчик') != -1 or item.name.lower().find('программист') != -1:
            for i in Spec.objects.all():
                if 'Математика' in i.ege.all() or 'Информатика и ИКТ' in i.ege.all():
                    data.append({
                        'data': {'id': item.name + '_' + i.name,
                                 'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})',
                                 'source': item.name, 'target': i.name}
                    })
        if item.category == 'Бизнес и управление' or item.name.lower().find('бизн') != -1 or item.name.lower().find(
                'менедж') != -1:
            for i in Spec.objects.all():
                if 'Обществознание' in i.ege.all():
                    data.append({
                        'data': {'id': item.name + '_' + i.name,
                                 'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})',
                                 'source': item.name, 'target': i.name}
                    })
        if item.category == 'Дизайн и UX' or item.name.lower().find('диза') != -1 or item.name.lower().find(
                'ui') != -1 or item.name.lower().find('ux') != -1:
            for i in Spec.objects.all():
                if 'Литература' in i.ege.all() or 'История' in i.ege.all():
                    data.append({
                        'data': {'id': item.name + '_' + i.name,
                                 'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})',
                                 'source': item.name, 'target': i.name}
                    })

    for item in Spec.objects.all():
        data.append({
            'data': {'id': item.name, 'url': item.url,
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
            'data': {'id': item.name, 'url': item.url,
                     'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})'}
        })
    return render(request, 'graph.html',
                  {'data': data, 'form': form, 'spec': Spec.objects.all(), 'prof': Profession.objects.all(),
                   'ege': Ege.objects.all()})


def math(request):
    if request.method == 'POST':
        prof = list()
        spec = list()
        pred = list()
        special = list()
        ret_prof = list()
        data = list()
        for item in request.POST:
            if item.startswith('want_spec'):
                spec.append(Spec.objects.get(pk=int(item.split('_')[2])))
            if item.startswith('want_prof'):
                prof.append(Profession.objects.get(pk=int(item.split('_')[2])))
            if item.startswith('prof_predmet'):
                pred.append(Ege.objects.get(pk=int(item.split('_')[2])))
        for item in pred:
            data.append({
                'data': {'id': item.name,
                         'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})'}
            })
            for i in spec:
                if item in i.ege.all():
                    data.append({
                        'data': {'id': item.name + '_' + i.name,
                                 'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})',
                                 'source': item.name, 'target': i.name}
                    })
                    special.append(i)
            for i in Kurses.objects.all():
                if i.category == 'Программирование' or i.name.lower().find(
                        'python') != -1 or i.name.lower().find(
                        'разработчик') != -1 or i.name.lower().find('программист') != -1 and (item.name == 'Математика' or item.name =='Информатика и ИКТ'):
                            data.append({
                                'data': {'id': item.name + '_' + i.name,
                                         'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})',
                                         'source': item.name, 'target': i.name}
                            })
                            data.append({
                                'data': {'id': i.name,
                                         'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})'}
                            })
                if i.category == 'Бизнес и управление' or i.name.lower().find(
                        'бизн') != -1 or i.name.lower().find(
                        'менедж') != -1 and item.name == 'Обществознание':
                            data.append({
                                'data': {'id': item.name + '_' + i.name,
                                         'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})',
                                         'source': item.name, 'target': i.name}
                            })
                            data.append({
                                'data': {'id': i.name,
                                'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})'}
                })
                if i.category == 'Дизайн и UX' or i.name.lower().find('диза') != -1 or i.name.lower().find(
                        'ui') != -1 or i.name.lower().find('ux') != -1 and (item.name == 'Литература' or item.name =='История'):
                            data.append({
                                'data': {'id': item.name + '_' + i.name,
                                         'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})',
                                         'source': item.name, 'target': i.name}
                            })
                            data.append({
                                'data': {'id': i.name,
                                         'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})'}
                            })
        for item in special:
            data.append({
                'data': {'id': item.name, 'url': item.url,
                         'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})'}
            })
            for i in Kurses.objects.all():
                if i.category == 'Программирование' and (item.name.lower().find(
                        'python') != -1 or item.name.lower().find(
                        'разработчик') != -1 or item.name.lower().find('программист') != -1):
                            data.append({
                                'data': {'id': item.name + '_' + i.name,
                                         'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})',
                                         'source': i.name, 'target': item.name}
                            })
                            data.append({
                                'data': {'id': i.name,
                                         'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})'}
                            })
                if i.category == 'Бизнес и управление' and (item.name.lower().find(
                        'бизн') != -1 or item.name.lower().find(
                        'менедж') != -1):
                            data.append({
                                'data': {'id': item.name + '_' + i.name,
                                         'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})',
                                         'source': i.name, 'target': item.name}
                            })
                            data.append({
                                'data': {'id': i.name,
                                'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})'}
                })
                if i.category == 'Дизайн и UX' and (item.name.lower().find('диза') != -1 or item.name.lower().find(
                        'ui') != -1 or item.name.lower().find('ux') != -1):
                            data.append({
                                'data': {'id': item.name + '_' + i.name,
                                         'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})',
                                         'source': i.name, 'target': item.name}
                            })
                            data.append({
                                'data': {'id': i.name,
                                         'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})'}
                            })
            for i in prof:
                if i in item.prof.all():
                    data.append({
                        'data': {'id': i.name, 'url': i.url,
                                 'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})'}
                    })
                    data.append({
                        'data': {'id': item.name + '_' + i.name,
                                 'bg': f'rgb({random.random() * 255},{random.random() * 255},{random.random() * 255})',
                                 'source': item.name, 'target': i.name}
                    })
        return JsonResponse({'data': data})


def create(request):
    if request.method == 'POST':
        plan = get_plan(request)
        plan.kurses.add(Kurses.objects.get(name='Цифровой маркетинг'))
        plan.kurses.add(Kurses.objects.get(name='DataOps-инженер'))
        plan.spec.add(Spec.objects.get(name='Информатика и вычислительная техника'))
        plan.spec.add(Spec.objects.get(name='Информационные системы и технологии'))
        plan.prof.add(Profession.objects.get(name='Специалист по системам безопасности'))
        plan.save()
        if request.user.is_authenticated:
            data = {'ok': True}
        else:
            data = {'ok': False}
    return JsonResponse(data)

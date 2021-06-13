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

locale.setlocale(locale.LC_ALL, "ru_RU")

def get_persondata(request):
    data = PersonData.objects.filter(owner=request.user).first()
    if not data:
        data = PersonData.objects.create(owner=request.user)
    return data


def main(request):




    return render(request, 'main.html')


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
    with open('prof_list.json', 'r', encoding='unicode-escape') as f:
        prof = json.load(f)
    with open('spec_list.json', 'r', encoding='unicode-escape') as f:
        spec = json.load(f)
    with open('spisok.json', 'r', encoding='unicode-escape') as f:
        spisok = json.load(f)
    with open('kurses_netology.json', 'r', encoding='unicode-escape') as f:
        kurses = json.load(f)
    for i in spisok[:20]:
        data.append({
            'data': {'id': i['vuz'], 'bg':f'rgb({random.random()*255},{random.random()*255},{random.random()*255})'}
        })
    for i in spec[:50]:
        data.append({
            'data': {'id': i['name'], 'url': i['url'], 'bg': f'rgb({random.random()*255},{random.random()*255},{random.random()*255})'},
        })
    for i in spisok[:20]:
        for j in spec[:50]:
            for k in i['spec']:
                if j['name'] == k['name']:
                    data.append({
                        'data': {'id': k['name'] + '_' + j['name'], 'source': i['vuz'], 'target': j['name']}
                    })
    for j in prof[:50]:
        data.append({
            'data': {'id': j['name'], 'url': j['url'], 'bg': f'rgb({random.random()*255},{random.random()*255},{random.random()*255})'},
        })
    for i in spec[:50]:
        for j in prof[:50]:
            if j['name'] in i['profession']:
                data.append({
                    'data': {'id': i['name'] + '_' + j['name'], 'bg': f'rgb({random.random()*255},{random.random()*255},{random.random()*255})', 'source': i['name'], 'target': j['name']}
                })

    return render(request, 'graph.html', {'data': data, 'form': form, 'spec':Spec.objects.all(), 'prof':Profession.objects.all(), 'ege':Ege.objects.all()})

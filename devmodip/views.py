from django.shortcuts import render, redirect
from .forms import *
from .forms import *
from django.contrib.auth import login, logout
from django.contrib.auth.models import User
import locale

locale.setlocale(locale.LC_ALL, "ru_RU")


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
    return render(request, 'graph.html')
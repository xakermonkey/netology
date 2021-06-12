from django import forms
from django.contrib.auth.forms import UserCreationForm, AuthenticationForm
from django.contrib.auth.models import User
from django.forms import ModelForm
from .models import *


class UserLoginForm(AuthenticationForm):
    username = forms.CharField(label='Логин:',
        widget=forms.TextInput(attrs={'class': 'form-control', 'style': ''}))
    password = forms.CharField(label='Пароль:',
                               widget=forms.PasswordInput(
                                   attrs={'class': 'form-control', 'style': ''}))

class UserRegisterForm(ModelForm):
    password1 = forms.CharField(label='Пароль', widget=forms.PasswordInput(attrs={'class': 'form-control'}))
    password2 = forms.CharField(label='Повторите пароль', widget=forms.PasswordInput(attrs={'class': 'form-control'}))

    class Meta:
        model = User
        fields = ['username', 'first_name', 'last_name', 'email']

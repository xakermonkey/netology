from django.shortcuts import render, redirect
from .forms import *
import locale

locale.setlocale(locale.LC_ALL, "ru_RU")


def main(request):
    return render(request, 'main.html')

def test(request):
    return render(request, 'test.html')
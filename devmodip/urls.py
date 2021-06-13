from . import views
from .views import *
from django.urls import path
from django.conf.urls.static import static
from django.conf import settings

urlpatterns = [
    path("", main, name='main'),
    path("test", test, name='test'),
    path('login', user_login, name='login'),
    path('logout', user_logout, name='logout'),
    path('register', register, name='register'),
    path('graph', graph, name='graph'),
    path('math', math, name='math'),

]

if settings.DEBUG:
    urlpatterns += static(settings.STATIC_URL, document_root=settings.STATIC_ROOT)
    urlpatterns += static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)

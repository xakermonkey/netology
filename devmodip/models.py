from django.db import models
from django.contrib.auth.models import User
# Create your models here.


class LearnPlan(models.Model):
    owner = models.ForeignKey(User, on_delete=models.CASCADE)
    spec = models.ManyToManyField('Spec')
    prof = models.ManyToManyField('Profession')
    kurses = models.ManyToManyField('Kurses')


    def __str__(self):
        return f'Учебный план {self.owner}'

    class Meta:
        verbose_name = 'Учебный план'
        verbose_name_plural = 'Учебные планы'


class Portfolio(models.Model):
    owner = models.ForeignKey(User, on_delete=models.CASCADE)
    spec = models.ManyToManyField('Spec')
    prof = models.ManyToManyField('Profession')
    kurses = models.ManyToManyField('Kurses')

    def __str__(self):
        return f'Достижения {self.owner}'

    class Meta:
        verbose_name = 'Достижение'
        verbose_name_plural = 'Достижения'

class PersonData(models.Model):
    owner = models.ForeignKey(User, on_delete=models.CASCADE)
    prof_predmet = models.ManyToManyField('Ege')
    hobbi = models.CharField(max_length=255, verbose_name='Хобби')
    want_prof = models.ManyToManyField('Profession')
    want_spec = models.ManyToManyField('Spec')


    def __str__(self):
        return f'Личные данные {self.owner}'

    class Meta:
        verbose_name = 'Личные данные'
        verbose_name_plural = 'Личные данные'

class Ege(models.Model):
    name = models.CharField(max_length=255, verbose_name='Название предмета')

    def __str__(self):
        return self.name

    class Meta:
        verbose_name = 'ЕГЭ'
        verbose_name_plural = 'ЕГЭ'


class Profession(models.Model):
    name = models.CharField(max_length=255, verbose_name='Название профессии')
    url = models.CharField(max_length=1000, verbose_name='Ссылка на подробное опичание профессии')

    def __str__(self):
        return self.name

    class Meta:
        verbose_name = 'Профессия'
        verbose_name_plural = 'Профессии'


class Spec(models.Model):
    name = models.CharField(max_length=255, verbose_name='Название специальности')
    url = models.CharField(max_length=1000, verbose_name='Ссылка на подробное опичание специальности')
    price = models.CharField(max_length=10, null=True, blank=True, verbose_name='Цена за обучение')
    budzhet = models.CharField(max_length=3, null=True, blank=True, verbose_name='Минимальный балл для поступления на бюджет')
    budzhet_mest = models.CharField(max_length=4, null=True, blank=True, verbose_name='Количество свободных мест на бюджет')
    platno = models.CharField(max_length=3, null=True, blank=True, verbose_name='Минимальный балл для поступления на платное')
    platno_mest = models.CharField(max_length=4, null=True, blank=True, verbose_name='Количество свободных мест на платное')
    ege = models.ManyToManyField(Ege)
    prof = models.ManyToManyField(Profession)

    def __str__(self):
        return self.name

    class Meta:
        verbose_name = 'Специальноть'
        verbose_name_plural = 'Специальности'




class Vuz(models.Model):
    name = models.CharField(max_length=255, verbose_name='Название вуза')
    obshaga = models.BooleanField(verbose_name='Общежитие')
    gos = models.BooleanField(verbose_name='Государственный')
    voen = models.BooleanField(verbose_name='Военная кафедра')
    accred = models.BooleanField(verbose_name='Акредитован/Лицензирован')
    spec = models.ManyToManyField(Spec)

    def __str__(self):
        return self.name

    class Meta:
        verbose_name = 'ВУЗ'
        verbose_name_plural = 'ВУЗы'


class Kurses(models.Model):
    name = models.CharField(max_length=255, verbose_name='Название профессии')
    url = models.CharField(max_length=1000, verbose_name='Ссылка на подробное опичание профессии')
    img = models.CharField(max_length=1000, verbose_name='Фотография', null=True, blank=True)
    level = models.CharField(max_length=255, verbose_name='Уровень подготовки', null=True, blank=True)
    vid = models.CharField(max_length=255, verbose_name='Вид подготовки', null=True, blank=True)
    category = models.CharField(max_length=255, verbose_name='Категория подготовки', null=True, blank=True)

    def __str__(self):
        return self.name

    class Meta:
        verbose_name = 'Курс'
        verbose_name_plural = 'Курсы'


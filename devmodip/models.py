from django.db import models
from django.contrib.auth.models import User
# Create your models here.


class LearnPlan(models.Model):
    owner = models.ForeignKey(User, on_delete=models.CASCADE)


    def __str__(self):
        return f'Учебный план {self.owner}'


class Portfolio(models.Model):
    owner = models.ForeignKey(User, on_delete=models.CASCADE)

    def __str__(self):
        return f'Достижения {self.owner}'

class PersonData(models.Model):
    owner = models.ForeignKey(User, on_delete=models.CASCADE)

    def __str__(self):
        return f'Личные данные {self.owner}'
import requests as r
from bs4 import BeautifulSoup as bs
import re
import json
import numpy as np
from selenium import webdriver
from time import sleep


# def get_retraining(url):
#     page = r.get(url).text
#     page = bs(page, 'lxml')
#     content = page.find('div', id='p_content')
#     kurs = list()
#     for item in content.find_all('div', class_='col-md-12'):
#         k = dict()
#         k['name'] = item.find('span', class_='description_wrapper').text
#         k['url'] = item.find('a').attrs['href']
#         kurs.append(k)
#     return kurs


page = r.get('https://dpo.online/retraining/').text
page = bs(page, 'lxml')

list_kurses = list()
# category = page.find_all('div', class_='panel panel-default')

# kurses = page.find_all('div', class_='gb-course-card js-course-card')
# for item in category:
#     retraining = dict()
#     retraining['name'] = item.find('h4', class_='panel-title').text
#     for i in item.find_all('li', class_='cat-item'):
#         if i.find('ul'):
#             for j in i.find_all('li'):
#                 retraining[j.find('a').text] = get_retraining(j.find('a').attrs['href'])
#         else:
#             retraining[i.find('a').text] = get_retraining(i.find('a').attrs['href'])
#     list_kurses.append(retraining)


# for item in kurses:
#     kurs = dict()
#     kurs['name'] = item.find('span', class_='gb-course-card__title-text').text.replace('\n', '')
#     kurs['url'] = 'https://gb.ru/courses/' + item.attrs['data-id']
#     try:
#         kurs['image'] = item.find('img', class_='gb-course-card__image')['src']
#     except:
#         kurs['image'] = ''
#     list_kurses.append(kurs)

with open('skillbox.json', 'w') as f:
    json.dump(list_kurses, f)

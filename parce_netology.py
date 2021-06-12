import requests as r
from bs4 import BeautifulSoup as bs
import re
import json
import numpy as np
from selenium import webdriver
from time import sleep

driver = webdriver.Chrome()

kurses = list()
driver.get('https://netology.ru/navigation')
sleep(5)
page = driver.find_element_by_class_name(
    'shared-components-ProgramsBlock-programsBlock-module__programs--1J_CV').find_elements_by_class_name(
    'shared-components-ProgramCard-programCard-module__root--1ggGE')

for item in page:
    kurs = dict()
    kurs['name'] = item.find_element_by_class_name('shared-components-ProgramCard-programCard-module__title--3_-mP').text
    prof = item.find_element_by_class_name('shared-components-ProgramCard-programCard-module__badges--21YtU')
    if len(prof.text.split('\n')) ==3:
        kurs['level'] = prof.text.split('\n')[0]
        kurs['vid'] = prof.text.split('\n')[1]
        kurs['category'] = prof.text.split('\n')[2]
    else:
        kurs['level'] = prof.text.split('\n')[0]
        kurs['vid'] = ''
        kurs['category'] = prof.text.split('\n')[1]
    kurs['url'] = item.get_attribute('href')
    # if item.text.split('\n')[0].find('%') != -1 and len(item.text.split('\n')) == 8:
    #     kurs['name'] = item.text.split('\n')[4]
    #     kurs['level'] = item.text.split('\n')[1]
    #     kurs['vid'] = item.text.split('\n')[2]
    #     kurs['category'] = item.text.split('\n')[3]
    #     kurs['url'] = item.get_attribute('href')
    # elif item.text.split('\n')[0].find('%') != -1 and len(item.text.split('\n')) == 7:
    #     kurs['name'] = item.text.split('\n')[3]
    #     kurs['level'] = item.text.split('\n')[1]
    #     kurs['vid'] = ''
    #     kurs['category'] = item.text.split('\n')[2]
    #     kurs['url'] = item.get_attribute('href')
    # elif item.text.split('\n')[0].find('%') == -1 and len(item.text.split('\n')) == 7:
    #     kurs['name'] = item.text.split('\n')[3]
    #     kurs['level'] = item.text.split('\n')[0]
    #     kurs['vid'] = item.text.split('\n')[1]
    #     kurs['category'] = item.text.split('\n')[2]
    #     kurs['url'] = item.get_attribute('href')
    # elif item.text.split('\n')[0].find('%') == -1 and len(item.text.split('\n')) == 6:
    #     kurs['name'] = item.text.split('\n')[2]
    #     kurs['level'] = item.text.split('\n')[0]
    #     kurs['vid'] = ''
    #     kurs['category'] = item.text.split('\n')[1]
    #     kurs['url'] = item.get_attribute('href')
    kurses.append(kurs)
driver.close()
with open('kurses_netology.json', 'w') as f:
    json.dump(kurses, f)

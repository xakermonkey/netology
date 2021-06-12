import requests as r
from bs4 import BeautifulSoup as bs
import re
import json
import numpy as np

# page = r.get('https://moeobrazovanie.ru/specialities_vuz').text
#
# page = bs(page, 'lxml')
#
# url = list()
# list_spec = page.find_all('a', class_='spec_articles_list_spec_link')
# for i in list_spec:
#     url.append([i.text, 'https://moeobrazovanie.ru' + i.attrs['href']])
#
# url = np.array(url)
#
# np.save('spec_url', url)
spec_list = list()
spec_url = np.load('spec_url.npy')
for name, url in spec_url:
    prof = dict()
    prof['name'] = name
    print(name)
    prof['url'] = url
    page = r.get(url).text
    page = bs(page, 'lxml')
    table = page.find('table', class_='specBody')
    forms = table.find_all('tr')[0].find_all('div', class_='spec_article_block_subcontent')
    forms_list = list()
    for item in forms:
        forms_list.append([item.find('a').text, re.sub(r'[^0-9]', '', item.find('span').text)])
        if forms_list[-1][1] == '':
            forms_list[-1][1] = 0
    prof['forms'] = forms_list
    ege_list = list()
    for item in table.find_all('div', class_='spec_article_exam'):
        ege_list.append(item.find_all('span')[1].text)
    prof['ege'] = ege_list
    profess = table.find_all('tr')
    proff = None
    for i in profess:
        if i.find('td'):
            if i.find('td').text == 'Будущие профессии':
                proff = i
                break
    profess_list = list()
    if proff:
        for item in proff.find_all('a'):
            profess_list.append(item.text)
        for i in proff.find_all('span'):
            try:
                i.attrs['class']
            except:
                profess_list.append(i.text)
    prof['profession'] = profess_list
    spec_list.append(prof)
    print(prof)

with open('spec_list.json', 'w') as f:
    json.dump(spec_list, f)
# with open('prof_list.json', 'r', encoding='unicode-escape') as fh:
#     data = json.load(fh)
#
# for prof in data:
#     for name, url in prof['spec']:
#         page = r.get(url).text
#         page = bs(page, 'lxml')

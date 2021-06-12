import requests as r
from bs4 import BeautifulSoup as bs
import re
import json
# [{'vuz':' ',
#    city: ,
#    obshaga:true/false ,
#    gos:true/false,
#    voen:true/false,
#    budzhet: true/false,
#    accred: true/false,
#    'spec': [{
#         'name':
#         'price':
#         budzet:
#           budzhet mest:
#          platno:
#           platno mest:
#          type:
#          ege: []
#           forms: []
#    },]
# }]

spisok = list()
for i in range(718):
    page = r.get(f'https://vuzopedia.ru/vuz/{i+1}').text
    page = bs(page, 'lxml')
    if page.find('h1', class_='mainTitle fc-white').text.find('Вузы России 2021') != -1:
        continue
    else:
        vuz = dict()
        vuz['vuz'] = page.find('h1', class_='mainTitle fc-white').text
        vuz['vuz'] = re.sub(r'[^А-я0-9 ]', '', vuz['vuz'])
        vuz['city'] = page.find('div', id='newChoose').find('span').text
        option = page.find('div', class_='vuzOpiton').find_all('i')
        vuz['obshaga'] = 'vuzok' in option[0]['class']
        vuz['gos'] = 'vuzok' in option[1]['class']
        vuz['voen'] = 'vuzok' in option[2]['class']
        vuz['budzhet'] = 'vuzok' in option[3]['class']
        vuz['accred'] = 'vuzok' in option[4]['class']
        vuz['spec'] = list()
        for j in page.find_all('div', class_='itemSpecAll'):
            spec = dict()
            spec['name'] = j.find('a', class_='spectittle').text
            spec['price'] = j.find_all('div', class_='col-md-4 itemSpecAllParamWHide newbl')[0]
            try:
                spec['price'] = spec['price'].find('a', class_='tooltipq').text.split(' ')[1]
            except:
                spec['price'] = '0'

            spec['budzhet'] = j.find_all('div', class_='col-md-4 itemSpecAllParamWHide newbl')[1]
            try:
                spec['budzhet mest'] = spec['budzhet'].find_all('a', class_='tooltipq')[2].text.split(' ')[0]
                spec['budzhet'] = spec['budzhet'].find_all('a', class_='tooltipq')[0].text.split(' ')[1]
            except:
                spec['budzhet'] = '0'
                spec['budzhet mest'] = '0'
            spec['platno'] = j.find_all('div', class_='col-md-4 itemSpecAllParamWHide newbl')[2]
            try:
                spec['platno mest'] = spec['platno'].find_all('a', class_='tooltipq')[2].text.split(' ')[0]
                spec['platno'] = spec['platno'].find_all('a', class_='tooltipq')[0].text.split(' ')[1]
            except:
                spec['platno'] = '0'
                spec['platno mest'] = '0'
            spec['type'] = \
                j.find('div', class_='itemSpecAllinfo').find_all('div')[1].text.replace(' ', '').replace('\n', '').split('|')[0]
            spec['forms'] = j.find('div', class_='itemSpecAllinfo').find_all('div')[1].text.replace(' ', '').split('|')[
                1].replace('\n', '').split(',')
            try:
                spec['ege'] = j.find('div', class_='egeInVuz').find('span').text.replace(' ', '').split(',')
            except:
                try:
                    spec['ege'] = j.find('div', class_='egeInVuzProg').find('span').text.replace(' ', '').split(',')
                except:
                    spec['ege'] = 'Не указано'
            spec['budzhet'] = re.sub(r'[^0-9]', '', spec['budzhet'])
            spec['budzhet mest'] = re.sub(r'[^0-9]', '', spec['budzhet mest'])
            spec['platno'] = re.sub(r'[^0-9]', '', spec['platno'])
            spec['platno mest'] = re.sub(r'[^0-9]', '', spec['platno mest'])
            vuz['spec'].append(spec)
        spisok.append(vuz)
        with open('spisok.json', 'w', encoding='unicode-escape') as fp:
            json.dump(spisok, fp)
        print(f'{i+1}/718')
with open('spisok.json', 'w', encoding='unicode-escape') as fp:
    json.dump(spisok, fp)

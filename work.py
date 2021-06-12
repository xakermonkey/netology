import json
import numpy as np

# url = np.load('spec_url.npy')
# print(url)

with open('kurses_netology.json', 'r', encoding='unicode-escape') as fh:
    data = json.load(fh)
for i in data:
    print(i['level'])
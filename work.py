import json
import numpy as np

# url = np.load('spec_url.npy')
# print(url)

with open('spec_list.json', 'r', encoding='unicode-escape') as fh:
    data = json.load(fh)
print(data)
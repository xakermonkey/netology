import json
import numpy as np

# url = np.load('spec_url.npy')
# print(url)

with open('retraining.json', 'r') as fh:
    data = json.load(fh)
for i in data:
    for j in i:
        if j != 'name':
            for indx,k in enumerate(i[j]):
                print(k)
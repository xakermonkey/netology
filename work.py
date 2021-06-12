import json
import numpy as np

# url = np.load('spec_url.npy')
# print(url)

with open('retraining.json', 'r') as fh:
    data = json.load(fh)
print(data)
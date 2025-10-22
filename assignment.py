import numpy as np
beta1 = 1.47
beta2 = 2.16
n = 10 
samples = np.random.beta(beta1, beta2, n)
print("Random Beta(1.47, 2.16) samples on [0,1]:")
for i, x in enumerate(samples, start=1):
    print(f"{i}: {x:.4f}")
a, b = -10, 20
transformed = a + (b - a) * samples
print("\nTransformed samples on [-10, 20]:")
for i, y in enumerate(transformed, start=1):
    print(f"{i}: {y:.4f}")
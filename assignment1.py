import numpy as np
from scipy.stats import norm, chi2

data = np.array([11.394, 10.728, 6.680, 8.050, 8.382, 8.740, 8.287, 7.979, 5.857, 13.521,
12.000, 9.496, 9.248, 6.529, 12.137, 11.383, 8.135, 11.752, 10.040, 8.615,
8.686, 6.416, 9.987, 11.282, 4.732, 9.344, 7.019, 6.735, 12.176, 4.247,
10.099, 6.254, 5.557, 9.376, 5.780, 7.129, 7.835, 9.648, 4.381, 5.801,
8.334, 9.454, 8.486, 7.256, 10.963, 10.544, 10.433, 10.425, 10.078, 7.709])

mu, sigma = np.mean(data), np.std(data, ddof=1)
bins = [4, 5.5, 7, 8.5, 10, 11.5, 13, 14.5]
obs, _ = np.histogram(data, bins=bins)
cdf = norm.cdf(bins, mu, sigma)
exp = np.diff(cdf) * len(data)

chi2_stat = np.sum((obs - exp)**2 / exp)
df = len(exp) - 1 - 2
p_value = 1 - chi2.cdf(chi2_stat, df)

print(f"Mean={mu:.3f}, SD={sigma:.3f}")
print(f"Chi2={chi2_stat:.3f}, df={df}, p={p_value:.3f}")

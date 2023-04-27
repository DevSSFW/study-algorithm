#include <iostream>
#include <algorithm>

using namespace std;

int price[10000];
int index, N, M;

int solve() {
	int l = 0, r = price[N - 1], res = 0;
	index = 0;

	while (l <= r) {
		int mid = (l + r) / 2, sum = 0;

		for (int i = 0; i < N; i++) {
			if (price[i] > mid) sum += mid;
			else sum += price[i];
		}

		if (sum <= M) {
			res = mid;
			l = mid + 1;
		}
		else r = mid - 1;
	}

	return res;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie();

	cin >> N;

	for (int i = 0; i < N; i++) cin >> price[i];
	sort(price, price + N);

	cin >> M;

	cout << solve();
}
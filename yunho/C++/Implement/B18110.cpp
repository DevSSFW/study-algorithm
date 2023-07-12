#include <iostream>
#include <cmath>
#include <vector>
#include <algorithm>

using namespace std;

int main() { //solved.ac
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;

	if (N == 0) {
		cout << 0;
		return 0;
	}

	vector<int> opinion;
	for (int i = 0; i < N; i++) {
		int cin_opinion;
		cin >> cin_opinion;

		opinion.push_back(cin_opinion);
	}

	sort(opinion.begin(), opinion.end());
	
	int sum = 0;
	int aver = round(N * 0.15);
	for (int i = aver; i < N - aver; i++) sum += opinion[i];

	cout << round(sum / (N - aver * 2.));
}
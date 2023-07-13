#include<iostream>
#include<queue>

using namespace std;

char map[601][601];
bool vis[601][601];

int main() { //헌내기는 친구가 필요해
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N, M;
	cin >> N >> M;

	queue<pair<int, int>> Q;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];

			if (map[i][j] == 'I') {
				Q.push({ i, j });
				vis[i][j] = true;
			}
		}
	}

	int count = 0;
	int dx[] = { 1, -1, 0, 0 }, dy[] = { 0, 0, 1, -1 };

	while (!Q.empty()) {
		pair<int, int> cur = Q.front();
		Q.pop();

		int row = cur.first, col = cur.second;

		for (int i = 0; i < 4; i++) {
			int r = row + dx[i];
			int c = col + dy[i];

			if (r < 0 || c < 0 || r >= N || c >= M || vis[r][c] || map[r][c] == 'X') continue;

			if (map[r][c] == 'P') count++;
			
			Q.push(make_pair(r, c));
			vis[r][c] = true;
		}
	}

	if (count == 0) cout << "TT";
	else cout << count;
}
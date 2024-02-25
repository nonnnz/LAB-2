#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Line {
    int xi, xj;

    Line(int xi, int xj) : xi(xi), xj(xj) {}
};

bool compareLines(const Line &a, const Line &b) {
    return a.xi < b.xi;
}

void selectLines(vector<Line> &lines, int xa, int xb) {
    vector<Line> selectedLines;
    
    int currentX = xa;
    int i = 0;

    while (i < lines.size() && currentX < xb) {
        int maxRight = -1;
        Line selectedLine(0, 0);

        // Find the line that covers the current point or extends the coverage
        while (i < lines.size() && lines[i].xi <= currentX) {
            if (lines[i].xj > maxRight) {
                maxRight = lines[i].xj;
                selectedLine = lines[i];
            }
            i++;
        }

        // If no line covers the current point or extends the coverage, it's not possible to form the desired straight line
        if (selectedLine.xi == 0 && selectedLine.xj == 0) {
            cout << "Not possible to form the desired straight line." << endl;
            return;
        }

        selectedLines.push_back(selectedLine);
        currentX = maxRight + 1;
    }

    // Output the result
    cout << selectedLines.size() << endl;
    for (const Line &line : selectedLines) {
        cout << line.xi << " " << line.xj << endl;
    }
}

int main() {
    int n;
    cin >> n;

    vector<Line> lines;
    for (int i = 0; i < n; i++) {
        int xi, xj;
        cin >> xi >> xj;
        lines.push_back(Line(xi, xj));
    }

    int xa, xb;
    cin >> xa >> xb;

    // Sort lines based on starting points
    sort(lines.begin(), lines.end(), compareLines);
    for (const Line &line : lines) {
        cout << line.xi << " " << line.xj << endl;
    }

    // Call the function to select lines and output the result
    selectLines(lines, xa, xb);

    return 0;
}

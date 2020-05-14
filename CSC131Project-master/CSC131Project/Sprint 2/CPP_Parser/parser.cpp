#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main(int argc, char* argv[]) {
    if (argc < 2) return 0;
    ifstream inFile(argv[1]);
    string year;
    string category;
    string winner;
    string entity;
    ofstream outFile("Output.txt");
    ofstream outFile2("removed.txt");
    if (inFile.is_open()) {
        
        while (!inFile.eof()) {
            getline(inFile, year, ',');
            getline(inFile, category, ',');
            getline(inFile, winner, ',');
            getline(inFile, entity);
            if (!category.find("ACT")) outFile2 << year << "," << category << "," << winner << "," << entity << '\n';
            else if (!category.find("SPECIAL")) outFile2 << year << "," << category << "," << winner << "," << entity<< '\n';
            else if (!category.find("SCIENTIFIC")) outFile2 << year << "," << category << "," << winner << "," << entity << '\n';
            else if (!category.find("HONORARY")) outFile2 << year << "," << category << "," << winner << "," << entity << '\n';
            else if (!category.find("COMMENDATION")) outFile2 << year << "," << category << "," << winner << "," << entity << '\n';
            else if (!category.find("GORDON")) outFile2 << year << "," << category << "," << winner << "," << entity << '\n';
            else if (!category.find("MEMORIAL")) outFile2 << year << "," << category << "," << winner << "," << entity << '\n';
            else if (!category.find("HUMANITARIAN")) outFile2 << year << "," << category << "," << winner << "," << entity << '\n';
            else if (!category.find("SPECIAL")) outFile2 << year << "," << category << "," << winner << "," << entity << '\n';
            else if (!category.find("AWARD")) outFile2 << year << "," << category << "," << winner << "," << entity << '\n';
            else outFile << year << "," << category << "," << winner << "," << entity << '\n';

        }
        inFile.close();
        outFile.close();
        outFile2.close();
    }
    else {
        cout << "failed";
    }
    cin.get();

    return 0;
}
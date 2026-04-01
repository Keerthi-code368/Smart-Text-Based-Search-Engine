# 🔍 Smart Text-Based Search Engine (Java)

A lightweight console-based search engine built in Java that indexes text documents and retrieves relevant results based on keyword frequency.

---

## 🚀 Features

- 📄 Indexes multiple text documents from a folder
- 🔍 Keyword-based search functionality
- 📊 Ranks results based on frequency of occurrence
- 🚫 Stop-word removal for improved relevance
- 🔁 Continuous search support until user exits
- ⚡ Efficient retrieval using inverted index (HashMap)

---

## 🧠 How It Works

1. Reads all text files from the `docs/` folder
2. Preprocesses text:
   - Converts to lowercase
   - Removes punctuation
   - Filters stop words
3. Builds an **inverted index**:
   - Maps each word → documents → frequency
4. Accepts user input for search
5. Displays ranked results based on frequency

---

## 🛠️ Tech Stack

- Java
- OOP (Object-Oriented Programming)
- Java Collections Framework (HashMap, HashSet)
- File Handling (BufferedReader, File)

---

## 📂 Project Structure


SmartTextSearchEngine/
│
├── docs/
│ ├── doc1.txt
│ ├── doc2.txt
│ └── doc3.txt
│
└── SearchEngine.java


---

## ▶️ How to Run

1. Compile the program:

javac SearchEngine.java


2. Run the program:

java SearchEngine


3. Enter keywords to search:

java
machine
search


4. Type `exit` to stop the program

---

## 📌 Example Output


Enter keyword to search: java
Document: doc1.txt | Frequency: 2
Document: doc3.txt | Frequency: 1


---

## 💡 Key Concepts Used

- Inverted Index
- String Processing
- Data Structures (HashMap, HashSet)
- Search Ranking Logic
- Stop-word Filtering

---

## 📈 Future Improvements

- Multi-keyword search support
- TF-IDF based ranking
- GUI interface
- File upload support

---
## 👩‍💻 Author

Kota Keerthi Sri

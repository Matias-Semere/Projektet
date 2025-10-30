PRAGMA foreign_keys = ON;

-- =====================================
-- USER (Unified login table)
-- =====================================
CREATE TABLE IF NOT EXISTS User (
    UserID INTEGER PRIMARY KEY,              -- auto-generated (no AUTOINCREMENT needed)
    Username TEXT UNIQUE NOT NULL,
    Password TEXT NOT NULL,
    Role TEXT CHECK(Role IN ('student', 'teacher', 'admin')) NOT NULL
);

-- =====================================
-- STUDENT
-- =====================================
CREATE TABLE IF NOT EXISTS Student (
    StudentID INTEGER PRIMARY KEY,
    UserID INTEGER UNIQUE NOT NULL,
    Namn TEXT NOT NULL,
    Årskull INTEGER NOT NULL,
    FOREIGN KEY (UserID) REFERENCES User(UserID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- =====================================
-- LÄRARE (Teacher)
-- =====================================
CREATE TABLE IF NOT EXISTS Lärare (
    LärareID INTEGER PRIMARY KEY,
    UserID INTEGER UNIQUE NOT NULL,
    Namn TEXT NOT NULL,
    FOREIGN KEY (UserID) REFERENCES User(UserID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- =====================================
-- ADMIN
-- =====================================
CREATE TABLE IF NOT EXISTS Admin (
    AdminID INTEGER PRIMARY KEY,
    UserID INTEGER UNIQUE NOT NULL,
    Namn TEXT NOT NULL,
    FOREIGN KEY (UserID) REFERENCES User(UserID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- =====================================
-- KURS (Course)
-- =====================================
CREATE TABLE IF NOT EXISTS Kurs (
    KursID INTEGER PRIMARY KEY,
    Namn TEXT NOT NULL,
    Studietakt REAL NOT NULL,
    Ort TEXT NOT NULL,
    Antal_platser INTEGER NOT NULL,
    Kurskod TEXT NOT NULL,
    Högskolepoäng REAL NOT NULL
);

-- =====================================
-- KURSTILLFÄLLE (Course Instance)
-- =====================================
CREATE TABLE IF NOT EXISTS Kurstillfälle (
    KurstillfälleID INTEGER PRIMARY KEY,
    KursID INTEGER NOT NULL,
    Datum TEXT NOT NULL,
    FOREIGN KEY (KursID) REFERENCES Kurs(KursID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- =====================================
-- REGISTERING (Student ↔ Kurstillfälle)
-- =====================================
CREATE TABLE IF NOT EXISTS Registering (
    StudentID INTEGER NOT NULL,
    KurstillfälleID INTEGER NOT NULL,
    PRIMARY KEY (StudentID, KurstillfälleID),
	UNIQUE (StudentID, KurstillfälleID),
    FOREIGN KEY (StudentID) REFERENCES Student(StudentID)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (KurstillfälleID) REFERENCES Kurstillfälle(KurstillfälleID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- =====================================
-- BETYG (Grades)
-- =====================================
CREATE TABLE IF NOT EXISTS Betyg (
    BetygID INTEGER PRIMARY KEY,
    StudentID INTEGER NOT NULL,
    KurstillfälleID INTEGER NOT NULL,
    Värde TEXT NOT NULL,
    FOREIGN KEY (StudentID) REFERENCES Student(StudentID)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (KurstillfälleID) REFERENCES Kurstillfälle(KurstillfälleID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- =====================================
-- RAPPORTERING (Reporting)
-- =====================================
CREATE TABLE IF NOT EXISTS Rapportering (
    RapporteringID INTEGER PRIMARY KEY,
    StudentID INTEGER NOT NULL,
    KurstillfälleID INTEGER NOT NULL,
    LärareID INTEGER NOT NULL,
    AdminID INTEGER NOT NULL,
    FOREIGN KEY (StudentID) REFERENCES Student(StudentID)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (KurstillfälleID) REFERENCES Kurstillfälle(KurstillfälleID)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (LärareID) REFERENCES Lärare(LärareID)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (AdminID) REFERENCES Admin(AdminID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS KursSchema (
    SchemaID INTEGER PRIMARY KEY,
    KurstillfälleID INTEGER NOT NULL,
    Datum TEXT NOT NULL,
    Starttid TEXT NOT NULL,
    Sluttid TEXT NOT NULL,
    Lokal TEXT NOT NULL,
    FOREIGN KEY (KurstillfälleID) REFERENCES Kurstillfälle(KurstillfälleID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Teacher Assignments
CREATE TABLE IF NOT EXISTS LärarTilldelning (
    TilldelningID INTEGER PRIMARY KEY,
    LärareID INTEGER NOT NULL,
    KurstillfälleID INTEGER NOT NULL,
    FOREIGN KEY (LärareID) REFERENCES Lärare(LärareID)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (KurstillfälleID) REFERENCES Kurstillfälle(KurstillfälleID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

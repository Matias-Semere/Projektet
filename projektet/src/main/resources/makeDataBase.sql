PRAGMA foreign_keys = ON;

-- =====================================
-- STUDENT
-- =====================================
CREATE TABLE Student (
    StudentID INTEGER PRIMARY KEY AUTOINCREMENT,
    Namn TEXT NOT NULL,
    Personnummer INTEGER NOT NULL,
    Årskull INTEGER NOT NULL
);

CREATE TABLE StudentInloggning (
    StudentID INTEGER PRIMARY KEY,
    Lösenord TEXT NOT NULL,
    FOREIGN KEY (StudentID) REFERENCES Student(StudentID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- =====================================
-- KURS
-- =====================================
CREATE TABLE Kurs (
    KursID INTEGER PRIMARY KEY AUTOINCREMENT,
    Namn TEXT NOT NULL,
    Studietakt REAL NOT NULL,
    Ort TEXT NOT NULL,
    Antal_platser INTEGER NOT NULL,
    Kurskod TEXT NOT NULL,
    Högskolepoäng REAL NOT NULL
);

-- =====================================
-- KURSTILLFÄLLE
-- =====================================
CREATE TABLE Kurstillfälle (
    KurstillfälleID INTEGER PRIMARY KEY AUTOINCREMENT,
    KursID INTEGER NOT NULL,
    Datum TEXT NOT NULL,
    FOREIGN KEY (KursID) REFERENCES Kurs(KursID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- =====================================
-- REGISTERING (Student ↔ Kurstillfälle)
-- =====================================
CREATE TABLE Registering (
    StudentID INTEGER NOT NULL,
    KurstillfälleID INTEGER NOT NULL,
    PRIMARY KEY (StudentID, KurstillfälleID),
    FOREIGN KEY (StudentID) REFERENCES Student(StudentID)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (KurstillfälleID) REFERENCES Kurstillfälle(KurstillfälleID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- =====================================
-- MOMENT (TEMPORARILY DISABLED)
-- =====================================
/*
CREATE TABLE Moment (
    MomentID INTEGER PRIMARY KEY AUTOINCREMENT,
    KurstillfälleID INTEGER NOT NULL,
    Beskrivning TEXT NOT NULL,
    FOREIGN KEY (KurstillfälleID) REFERENCES Kurstillfälle(KurstillfälleID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
*/

-- =====================================
-- BETYG
-- =====================================
CREATE TABLE Betyg (
    BetygID INTEGER PRIMARY KEY AUTOINCREMENT,
    StudentID INTEGER NOT NULL,
    -- MomentID INTEGER,  -- Uncomment if you later re-enable Moment
    KurstillfälleID INTEGER NOT NULL,
    Värde TEXT NOT NULL,
    FOREIGN KEY (StudentID) REFERENCES Student(StudentID)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    -- FOREIGN KEY (MomentID) REFERENCES Moment(MomentID)
    --     ON DELETE CASCADE
    --     ON UPDATE CASCADE,
    FOREIGN KEY (KurstillfälleID) REFERENCES Kurstillfälle(KurstillfälleID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- =====================================
-- LÄRARE
-- =====================================
CREATE TABLE Lärare (
    LärareID INTEGER PRIMARY KEY AUTOINCREMENT,
    Namn TEXT NOT NULL,
    Personnummer INTEGER NOT NULL,
    KurstillfälleID INTEGER NOT NULL,
    FOREIGN KEY (KurstillfälleID) REFERENCES Kurstillfälle(KurstillfälleID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- =====================================
-- ADMIN
-- =====================================
CREATE TABLE Admin (
    AdminID INTEGER PRIMARY KEY AUTOINCREMENT,
    Namn TEXT NOT NULL,
    Epost TEXT NOT NULL,
    Roll TEXT NOT NULL
);

-- =====================================
-- RAPPORTERING
-- =====================================
CREATE TABLE Rapportering (
    RapporteringID INTEGER PRIMARY KEY AUTOINCREMENT,
    StudentID INTEGER NOT NULL,
    -- MomentID INTEGER,  -- Uncomment when Moment is used
    KurstillfälleID INTEGER NOT NULL,
    LärareID INTEGER NOT NULL,
    AdminID INTEGER NOT NULL,
    FOREIGN KEY (StudentID) REFERENCES Student(StudentID)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    -- FOREIGN KEY (MomentID) REFERENCES Moment(MomentID)
    --     ON DELETE CASCADE
    --     ON UPDATE CASCADE,
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

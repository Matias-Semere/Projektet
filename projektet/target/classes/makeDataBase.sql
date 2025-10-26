PRAGMA foreign_keys = ON;

CREATE TABLE Student (
    StudentID INTEGER NOT NULL,
    Namn TEXT NOT NULL,
    Personnummer INTEGER NOT NULL,
    Arskull INTEGER NOT NULL,
    CONSTRAINT pk_Student PRIMARY KEY (StudentID)
);

CREATE TABLE StudentInloggning (
    StudentID INTEGER NOT NULL,
    Losenord TEXT NOT NULL,
    CONSTRAINT pk_StudentInloggning PRIMARY KEY (StudentID),
    CONSTRAINT fk_StudentInloggning_Student
        FOREIGN KEY (StudentID) REFERENCES Student (StudentID)
        ON DELETE CASCADE
);

CREATE TABLE Kurs (
    KursID INTEGER NOT NULL,
    Namn TEXT NOT NULL,
    Studietakt REAL NOT NULL,
    Ort TEXT NOT NULL,
    Studieplatser INTEGER NOT NULL,
    Kurskod TEXT NOT NULL,
    Hogskolepoang REAL NOT NULL,
    CONSTRAINT pk_Kurs PRIMARY KEY (KursID)
);

CREATE TABLE Kurstillfalle (
    Kurstillfalle TEXT NOT NULL,
    KursID INTEGER NOT NULL,
    Datum TEXT NOT NULL,
    CONSTRAINT pk_Kurstillfalle PRIMARY KEY (Kurstillfalle),
    CONSTRAINT fk_Kurstillfalle_Kurs
        FOREIGN KEY (KursID) REFERENCES Kurs (KursID)
        ON DELETE CASCADE
);

CREATE TABLE Registering (
    StudentID INTEGER NOT NULL,
    Kurstillfalle TEXT NOT NULL,
    CONSTRAINT pk_Registering PRIMARY KEY (StudentID, Kurstillfalle),
    CONSTRAINT fk_Registering_Student
        FOREIGN KEY (StudentID) REFERENCES Student (StudentID)
        ON DELETE CASCADE,
    CONSTRAINT fk_Registering_Kurstillfalle
        FOREIGN KEY (Kurstillfalle) REFERENCES Kurstillfalle (Kurstillfalle)
        ON DELETE CASCADE
);

CREATE TABLE Moment (
    MomentID TEXT NOT NULL,
    Kurstillfalle TEXT NOT NULL,
    Beskrivning TEXT NOT NULL,
    CONSTRAINT pk_Moment PRIMARY KEY (MomentID),
    CONSTRAINT fk_Moment_Kurstillfalle
        FOREIGN KEY (Kurstillfalle) REFERENCES Kurstillfalle (Kurstillfalle)
        ON DELETE CASCADE
);

CREATE TABLE Betyg (
    BetygID INTEGER NOT NULL,
    StudentID INTEGER NOT NULL,
    MomentID TEXT NOT NULL,
    Typ TEXT NOT NULL,
    Varde TEXT NOT NULL,
    CONSTRAINT pk_Betyg PRIMARY KEY (BetygID),
    CONSTRAINT fk_Betyg_Student
        FOREIGN KEY (StudentID) REFERENCES Student (StudentID)
        ON DELETE CASCADE,
    CONSTRAINT fk_Betyg_Moment
        FOREIGN KEY (MomentID) REFERENCES Moment (MomentID)
        ON DELETE CASCADE
);

CREATE TABLE Larare (
    LarareID INTEGER NOT NULL,
    Namn TEXT NOT NULL,
    Personnummer INTEGER NOT NULL,
    Kurstillfalle TEXT NOT NULL,
    CONSTRAINT pk_Larare PRIMARY KEY (LarareID),
    CONSTRAINT fk_Larare_Kurstillfalle
        FOREIGN KEY (Kurstillfalle) REFERENCES Kurstillfalle (Kurstillfalle)
        ON DELETE CASCADE
);

CREATE TABLE Admin (
    AdminID INTEGER NOT NULL,
    Namn TEXT NOT NULL,
    Epost TEXT NOT NULL,
    Roll TEXT NOT NULL,
    CONSTRAINT pk_Admin PRIMARY KEY (AdminID)
);

CREATE TABLE Rapportering (
    RapporteringID INTEGER NOT NULL,
    StudentID INTEGER NOT NULL,
    MomentID TEXT NOT NULL,
    Kurstillfalle TEXT NOT NULL,
    LarareID INTEGER NOT NULL,
    AdminID INTEGER NOT NULL,
    CONSTRAINT pk_Rapportering PRIMARY KEY (RapporteringID),
    CONSTRAINT fk_Rapportering_Student
        FOREIGN KEY (StudentID) REFERENCES Student (StudentID)
        ON DELETE CASCADE,
    CONSTRAINT fk_Rapportering_Moment
        FOREIGN KEY (MomentID) REFERENCES Moment (MomentID)
        ON DELETE CASCADE,
    CONSTRAINT fk_Rapportering_Kurstillfalle
        FOREIGN KEY (Kurstillfalle) REFERENCES Kurstillfalle (Kurstillfalle)
        ON DELETE CASCADE,
    CONSTRAINT fk_Rapportering_Larare
        FOREIGN KEY (LarareID) REFERENCES Larare (LarareID)
        ON DELETE CASCADE,
    CONSTRAINT fk_Rapportering_Admin
        FOREIGN KEY (AdminID) REFERENCES Admin (AdminID)
        ON DELETE CASCADE
);

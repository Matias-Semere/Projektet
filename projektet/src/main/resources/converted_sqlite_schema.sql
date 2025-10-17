PRAGMA foreign_keys = ON;

CREATE TABLE "Student" (
    "StudentID" INTEGER  NOT NULL,
    "Namn" TEXT  NOT NULL,
    "Personnummer" INTEGER  NOT NULL,
    "Arskull" INTEGER  NOT NULL,
    CONSTRAINT "pk_Student" PRIMARY KEY (
        "StudentID"
    )
);

CREATE TABLE "StudentInloggning" (
    "StudentID" INTEGER  NOT NULL,
    "Losenord" TEXT  NOT NULL,
    CONSTRAINT "pk_StudentInloggning" PRIMARY KEY (
        "StudentID"
    )
);

CREATE TABLE "Kurs" (
    "KursID" INTEGER  NOT NULL,
    "Namn" TEXT  NOT NULL,
    "Studietakt" REAL  NOT NULL,
    "Ort" TEXT  NOT NULL,
    "Studieplatser" INTEGER  NOT NULL,
    "Kurskod" TEXT  NOT NULL,
    "Hogskolepoang" REAL  NOT NULL,
    CONSTRAINT "pk_Kurs" PRIMARY KEY (
        "KursID"
    )
);

CREATE TABLE "Kurstillfalle" (
    "Kurstillfalle" TEXT  NOT NULL,
    "KursID" INTEGER  NOT NULL,
    "Datum" TEXT  NOT NULL,
    CONSTRAINT "pk_Kurstillfalle" PRIMARY KEY (
        "Kurstillfalle"
    )
);

CREATE TABLE "Registering" (
    "StudentID" INTEGER  NOT NULL,
    "Kurstillfalle" TEXT  NOT NULL
);

CREATE TABLE "Moment" (
    "MomentID" TEXT  NOT NULL,
    "Kurstillfalle" TEXT  NOT NULL,
    "Beskrivning" TEXT  NOT NULL,
    CONSTRAINT "pk_Moment" PRIMARY KEY (
        "MomentID"
    )
);

CREATE TABLE "Betyg" (
    "BetygID" INTEGER  NOT NULL,
    "StudentID" INTEGER  NOT NULL,
    "MomentID" TEXT  NOT NULL,
    "Typ" TEXT  NOT NULL,
    "Varde" TEXT  NOT NULL,
    CONSTRAINT "pk_Betyg" PRIMARY KEY (
        "BetygID"
    )
);

CREATE TABLE "Larare" (
    "LarareID" INTEGER  NOT NULL,
    "Namn" TEXT  NOT NULL,
    "Personnummer" INTEGER  NOT NULL,
    "Kurstillfalle" TEXT  NOT NULL,
    CONSTRAINT "pk_Larare" PRIMARY KEY (
        "LarareID"
    )
);

CREATE TABLE "Rapportering" (
    "RapporteringID" INTEGER  NOT NULL,
    "StudentID" INTEGER  NOT NULL,
    "MomentID" TEXT  NOT NULL,
    "Kurstillfalle" TEXT  NOT NULL,
    "LarareID" INTEGER  NOT NULL,
    "AdminID" INTEGER  NOT NULL,
    CONSTRAINT "pk_Rapportering" PRIMARY KEY (
        "RapporteringID"
    )
);

CREATE TABLE "Admin" (
    "AdminID" INTEGER  NOT NULL,
    "Namn" TEXT  NOT NULL,
    "Epost" TEXT  NOT NULL,
    "Roll" TEXT  NOT NULL,
    CONSTRAINT "pk_Admin" PRIMARY KEY (
        "AdminID"
    )
);
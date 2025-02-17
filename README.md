## Struttura del Database

### Tabella: `autore`

| Field       | Type         | Null | Key | Default | Extra          |
|-------------|--------------|------|-----|---------|----------------|
| id          | bigint       | NO   | PRI | NULL    | auto_increment |
| cognome     | varchar(128) | YES  |     | NULL    |                |
| nazionalita | varchar(2)   | YES  |     | NULL    |                |
| nome        | varchar(64)  | YES  |     | NULL    |                |

### Tabella: `libro`

| Field             | Type        | Null | Key | Default | Extra          |
|-------------------|-------------|------|-----|---------|----------------|
| id                | bigint      | NO   | PRI | NULL    | auto_increment |
| ibsn              | varchar(64) | YES  |     | NULL    |                |
| anno_publicazione | int         | NO   |     | NULL    |                |
| titolo            | varchar(64) | YES  |     | NULL    |                |
| autore_id         | bigint      | YES  | MUL | NULL    |                |

### Tabella: `genere`

| Field | Type        | Null | Key | Default | Extra          |
|-------|-------------|------|-----|---------|----------------|
| id    | bigint      | NO   | PRI | NULL    | auto_increment |
| nome  | varchar(64) | YES  |     | NULL    |                |

### Tabella: `libro_generi` (Ponte)

| Field     | Type   | Null | Key | Default | Extra |
|-----------|--------|------|-----|---------|-------|
| libri_id  | bigint | NO   | MUL | NULL    |       |
| generi_id | bigint | NO   | MUL | NULL    |       |

## Relazioni tra le Tabelle

- La tabella `libro` ha una relazione `ManyToOne` con la tabella `autore` tramite il campo `autore_id`.
- La tabella `libro` ha una relazione `ManyToMany` con la tabella `genere` tramite la tabella ponte `libro_generi`.

## Inserimenti nel Database

### Inserimenti nella tabella `autore`:

```sql
INSERT INTO autore (cognome, nazionalita, nome) VALUES
('Rossi', 'IT', 'Giovanni'),
('Bianchi', 'IT', 'Marco'),
('Verdi', 'IT', 'Luca'),
('Neri', 'FR', 'Pierre'),
('Dupont', 'FR', 'Jacques'),
('Lemoine', 'FR', 'Sylvain'),
('Müller', 'DE', 'Hans'),
('Schmidt', 'DE', 'Stefan'),
('García', 'ES', 'Carlos'),
('Martínez', 'ES', 'José');
```

### Inserimenti nella tabella `libro`:

```sql
INSERT INTO libro (ibsn, anno_publicazione, titolo, autore_id) VALUES
('978-3-16-148410-0', 2020, 'Il codice nascosto', 1),
('978-0-06-112008-4', 2019, 'Il cuore del cielo', 2),
('978-1-56619-909-4', 2018, 'La luce che brilla', 3),
('978-3-16-148411-7', 2021, 'Vento di cambiamento', 4),
('978-0-7432-7356-5', 2017, 'Il suono del silenzio', 5),
('978-0-452-28423-4', 2022, 'Oltre l orizzonte', 6),
('978-0-679-74578-2', 2020, 'Il segreto di un sorriso', 7),
('978-1-250-09258-9', 2023, 'La strada verso il futuro', 8),
('978-0-006-245771-3', 2021, 'Ombra di un sogno', 9),
('978-0-451-46871-5', 2022, 'Fuga da una realtà', 10),
('978-3-16-148410-0', 1995, 'Passione senza fine', 1),
('978-1-234-56789-0', 1998, 'Pellegrinaggio verso la libertà', 2),
('978-0-14-028333-4', 2001, 'Punti di vista', 3),
('978-0-399-15352-5', 2004, 'Porto sicuro', 4),
('978-0-7636-2578-2', 1997, 'Poesia di un sogno', 5),
('978-0-007-294345-9', 2002, 'La promessa del futuro', 6),
('978-0-141-19953-2', 1999, 'Perdono', 7),
('978-0-7636-2578-2', 2000, 'Pianeti lontani', 8),
('978-0-307-44767-0', 1995, 'Pazzo amore', 9),
('978-0-679-77925-1', 2003, 'Progetto speranza', 10);
```

### Inserimenti nella tabella `genere`

```sql
INSERT INTO genere (nome) VALUES
('Narrativa'),
('Avventura'),
('Fantascienza'),
('Romantico'),
('Mistero'),
('Thriller'),
('Storico'),
('Fantasy'),
('Drammatico'),
('Biografico'),
('Fantastico'),
('Giallo'),
('Sospense'),
('Classico'),
('Storico-fantastico'),
('Realismo magico'),
('Action'),
('Psicologico'),
('Poesia'),
('Contemporaneo');
```

### Inserimenti nella tabella `libro_generi`:

```sql
INSERT INTO libro_generi (libri_id, generi_id) VALUES
(1, 1),
(1, 5),
(2, 2),
(2, 4),
(3, 3),
(3, 7),
(4, 4),
(4, 9),
(5, 5),
(5, 6),
(6, 6),
(6, 1),
(7, 7),
(7, 10),
(8, 8),
(8, 4),
(9, 9),
(9, 10),
(10, 10),
(11, 1),
(11, 4),
(12, 2),
(12, 7),
(13, 11),
(13, 3),
(14, 6),
(14, 9),
(15, 12),
(15, 3),
(16, 1),
(16, 13),
(17, 13),
(17, 9),
(18, 14),
(18, 7),
(19, 15),
(19, 9),
(20, 16),
(20, 13);
```
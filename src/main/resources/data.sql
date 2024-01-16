INSERT INTO SUBJECT (ID, ABBREVIATION, TEACHER, CREATED_AT, MODIFIED_AT) VALUES (1, 'PPJ', 'John', TIMESTAMP '2021-07-22 15.33.11', TIMESTAMP '2021-09-22 15.33.11');
INSERT INTO SUBJECT (ID, ABBREVIATION, TEACHER, CREATED_AT, MODIFIED_AT) VALUES (2, 'UTP', 'Phil', TIMESTAMP '2022-05-23 14.55.34', TIMESTAMP '2022-11-23 14.55.34');
INSERT INTO SUBJECT (ID, ABBREVIATION, TEACHER, CREATED_AT, MODIFIED_AT) VALUES (3, 'GUI', 'Adam', TIMESTAMP '2023-11-09 12.33.23', TIMESTAMP '2024-01-09 12.33.23');

INSERT INTO PROJECT (ID, NAME, COMMENT, SUBJECT_ID, CREATED_AT, MODIFIED_AT) VALUES (1, 'Project 1', 'Comment 1', 1, TIMESTAMP '2021-07-22 15.33.11', TIMESTAMP '2021-09-22 15.33.11');
INSERT INTO PROJECT (ID, NAME, COMMENT, SUBJECT_ID, CREATED_AT, MODIFIED_AT) VALUES (2, 'Project 2', 'Comment 2', 2, TIMESTAMP '2021-07-22 15.33.11', TIMESTAMP '2021-09-22 15.33.11');
INSERT INTO PROJECT (ID, NAME, COMMENT, SUBJECT_ID, CREATED_AT, MODIFIED_AT) VALUES (3, 'Project 3', 'Comment 3', 2, TIMESTAMP '2021-07-22 15.33.11', TIMESTAMP '2021-09-22 15.33.11');
INSERT INTO PROJECT (ID, NAME, COMMENT, SUBJECT_ID, CREATED_AT, MODIFIED_AT) VALUES (4, 'Project 4', 'Comment 4', 3, TIMESTAMP '2021-07-22 15.33.11', TIMESTAMP '2021-09-22 15.33.11');
INSERT INTO PROJECT (ID, NAME, COMMENT, SUBJECT_ID, CREATED_AT, MODIFIED_AT) VALUES (5, 'Project 5', 'Comment 5', 3, TIMESTAMP '2021-07-22 15.33.11', TIMESTAMP '2021-09-22 15.33.11');

INSERT INTO STUDENT (ID, NAME, SURNAME, CREATED_AT, MODIFIED_AT) VALUES (1, 'John', 'Smith', TIMESTAMP '2021-07-22 15.33.11', TIMESTAMP '2021-09-22 15.33.11');
INSERT INTO STUDENT (ID, NAME, SURNAME, CREATED_AT, MODIFIED_AT) VALUES (2, 'Phil', 'Brown', TIMESTAMP '2021-07-22 15.33.11', TIMESTAMP '2021-09-22 15.33.11');
INSERT INTO STUDENT (ID, NAME, SURNAME, CREATED_AT, MODIFIED_AT) VALUES (3, 'Adam', 'White', TIMESTAMP '2021-07-22 15.33.11', TIMESTAMP '2021-09-22 15.33.11');
INSERT INTO STUDENT (ID, NAME, SURNAME, CREATED_AT, MODIFIED_AT) VALUES (4, 'Jack', 'Green', TIMESTAMP '2021-07-22 15.33.11', TIMESTAMP '2021-09-22 15.33.11');
INSERT INTO STUDENT (ID, NAME, SURNAME, CREATED_AT, MODIFIED_AT) VALUES (5, 'Kate', 'Black', TIMESTAMP '2021-07-22 15.33.11', TIMESTAMP '2021-09-22 15.33.11');

INSERT INTO GRADE (ID, GRADE, PROJECT_ID, STUDENT_ID, CREATED_AT, MODIFIED_AT) VALUES (1, 5, 1, 1, TIMESTAMP '2021-07-22 15.33.11', TIMESTAMP '2021-09-22 15.33.11');
INSERT INTO GRADE (ID, GRADE, PROJECT_ID, STUDENT_ID, CREATED_AT, MODIFIED_AT) VALUES (2, 4, 1, 2, TIMESTAMP '2021-07-22 15.33.11', TIMESTAMP '2021-09-22 15.33.11');
INSERT INTO GRADE (ID, GRADE, PROJECT_ID, STUDENT_ID, CREATED_AT, MODIFIED_AT) VALUES (3, 3, 1, 3, TIMESTAMP '2021-07-22 15.33.11', TIMESTAMP '2021-09-22 15.33.11');
INSERT INTO GRADE (ID, GRADE, PROJECT_ID, STUDENT_ID, CREATED_AT, MODIFIED_AT) VALUES (4, 2, 1, 4, TIMESTAMP '2021-07-22 15.33.11', TIMESTAMP '2021-09-22 15.33.11');
INSERT INTO GRADE (ID, GRADE, PROJECT_ID, STUDENT_ID, CREATED_AT, MODIFIED_AT) VALUES (5, 1, 1, 5, TIMESTAMP '2021-07-22 15.33.11', TIMESTAMP '2021-09-22 15.33.11');
INSERT INTO GRADE (ID, GRADE, PROJECT_ID, STUDENT_ID, CREATED_AT, MODIFIED_AT) VALUES (6, 5, 2, 1, TIMESTAMP '2021-07-22 15.33.11', TIMESTAMP '2021-09-22 15.33.11');
INSERT INTO GRADE (ID, GRADE, PROJECT_ID, STUDENT_ID, CREATED_AT, MODIFIED_AT) VALUES (7, 4, 2, 2, TIMESTAMP '2021-07-22 15.33.11', TIMESTAMP '2021-09-22 15.33.11');
INSERT INTO GRADE (ID, GRADE, PROJECT_ID, STUDENT_ID, CREATED_AT, MODIFIED_AT) VALUES (8, 3, 2, 3, TIMESTAMP '2021-07-22 15.33.11', TIMESTAMP '2021-09-22 15.33.11');
INSERT INTO GRADE (ID, GRADE, PROJECT_ID, STUDENT_ID, CREATED_AT, MODIFIED_AT) VALUES (9, 2, 2, 4, TIMESTAMP '2021-07-22 15.33.11', TIMESTAMP '2021-09-22 15.33.11');
INSERT INTO GRADE (ID, GRADE, PROJECT_ID, STUDENT_ID, CREATED_AT, MODIFIED_AT) VALUES (10, 1, 2, 5, TIMESTAMP '2021-07-22 15.33.11', TIMESTAMP '2021-09-22 15.33.11');
INSERT INTO GRADE (ID, GRADE, PROJECT_ID, STUDENT_ID, CREATED_AT, MODIFIED_AT) VALUES (11, 5, 3, 1, TIMESTAMP '2021-07-22 15.33.11', TIMESTAMP '2021-09-22 15.33.11');
INSERT INTO GRADE (ID, GRADE, PROJECT_ID, STUDENT_ID, CREATED_AT, MODIFIED_AT) VALUES (12, 4, 3, 2, TIMESTAMP '2021-07-22 15.33.11', TIMESTAMP '2021-09-22 15.33.11');
INSERT INTO GRADE (ID, GRADE, PROJECT_ID, STUDENT_ID, CREATED_AT, MODIFIED_AT) VALUES (13, 3, 3, 3, TIMESTAMP '2021-07-22 15.33.11', TIMESTAMP '2021-09-22 15.33.11');
INSERT INTO GRADE (ID, GRADE, PROJECT_ID, STUDENT_ID, CREATED_AT, MODIFIED_AT) VALUES (14, 2, 3, 4, TIMESTAMP '2021-07-22 15.33.11', TIMESTAMP '2021-09-22 15.33.11');
INSERT INTO GRADE (ID, GRADE, PROJECT_ID, STUDENT_ID, CREATED_AT, MODIFIED_AT) VALUES (15, 1, 3, 5, TIMESTAMP '2021-07-22 15.33.11', TIMESTAMP '2021-09-22 15.33.11');
INSERT INTO GRADE (ID, GRADE, PROJECT_ID, STUDENT_ID, CREATED_AT, MODIFIED_AT) VALUES (16, 5, 4, 1, TIMESTAMP '2021-07-22 15.33.11', TIMESTAMP '2021-09-22 15.33.11');
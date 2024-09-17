USE BookMyStudySession;

-- Insert Features
-- Insert Topics (for class 10, subject Mathematics)
INSERT INTO Topics (classLevel, subject, topicName)
VALUES (12, 'Chemistry', 'Alcohols'),
       (12, 'Chemistry', 'Solutions'),
       (12, 'Chemistry', 'Haloalkanes and Haloarenes'),
       (12, 'Chemistry', 'Aldehydes, Ketones, and Carboxylic Acids'),
       (12, 'Chemistry', 'Amines'),
       (12, 'Chemistry', 'Biomolecules'),
       (12, 'Chemistry', 'Polymers'),
       (12, 'Chemistry', 'Chemistry in Everyday Life'),
       (12, 'Physics', 'Electrostatics'),
       (12, 'Physics', 'Current Electricity'),
       (12, 'Physics', 'Magnetic Effects of Current and Magnetism'),
       (12, 'Physics', 'Electromagnetic Induction and Alternating Currents'),
       (12, 'Physics', 'Ray Optics and Optical Instruments'),
       (12, 'Physics', 'Dual Nature of Matter and Radiation'),
       (12, 'Physics', 'Atoms and Nuclei'),
       (12, 'Physics', 'Semiconductors'),
       (12, 'Physics', 'Communication Systems');

-- Insert SubTopics for Alcohols
INSERT INTO SubTopics (topicId, subTopicName)
VALUES (1, 'Classification'),
       (1, 'Preparation'),
       (1, 'Physical properties'),
       (1, 'Chemical reactions');

-- Insert SubTopics for Solutions
INSERT INTO SubTopics (topicId, subTopicName)
VALUES (2, 'Types of solutions'),
       (2, 'Expressing concentration of solutions'),
       (2, 'Solubility'),
       (2, 'Raoults law'),
       (2, 'Abnormal molar masses');

-- Insert SubTopics for Haloalkanes and Haloarenes
INSERT INTO SubTopics (topicId, subTopicName)
VALUES (3, 'Nomenclature'),
       (3, 'Preparation'),
       (3, 'Physical properties'),
       (3, 'Chemical reactions');

-- Insert SubTopics for Aldehydes, Ketones, and Carboxylic Acids
INSERT INTO SubTopics (topicId, subTopicName)
VALUES (4, 'Nomenclature'),
       (4, 'Preparation'),
       (4, 'Physical properties'),
       (4, 'Chemical reactions');

-- Insert SubTopics for Amines
INSERT INTO SubTopics (topicId, subTopicName)
VALUES (5, 'Classification'),
       (5, 'Preparation'),
       (5, 'Physical properties'),
       (5, 'Chemical reactions');

-- Insert SubTopics for Biomolecules
INSERT INTO SubTopics (topicId, subTopicName)
VALUES (6, 'Carbohydrates'),
       (6, 'Proteins'),
       (6, 'Enzymes'),
       (6, 'Vitamins'),
       (6, 'Nucleic acids');

-- Insert SubTopics for Polymers
INSERT INTO SubTopics (topicId, subTopicName)
VALUES (7, 'Classification'),
       (7, 'Preparation'),
       (7, 'Properties'),
       (7, 'Uses');

-- Insert SubTopics for Chemistry in Everyday Life
INSERT INTO SubTopics (topicId, subTopicName)
VALUES (8, 'Drugs'),
       (8, 'Chemicals in food'),
       (8, 'Cleansing agents');

-- Insert SubTopics for Electrostatics
INSERT INTO SubTopics (topicId, subTopicName)
VALUES (9, 'Electric charge'),
       (9, 'Coulombs law'),
       (9, 'Electric field'),
       (9, 'Electric potential'),
       (9, 'Capacitors');

-- Insert SubTopics for Current Electricity
INSERT INTO SubTopics (topicId, subTopicName)
VALUES (10, 'Electric current'),
       (10, 'Ohms law'),
       (10, 'Electrical resistance'),
       (10, 'Series and parallel combination of resistors'),
       (10, 'Kirchhoffs laws'),
       (10, 'Wheatstone bridge'),
       (10, 'Potentiometer');

-- Insert SubTopics for Magnetic Effects of Current and Magnetism
INSERT INTO SubTopics (topicId, subTopicName)
VALUES (11, 'Magnetic field due to a current-carrying conductor'),
       (11, 'Force on a current-carrying conductor in a magnetic field'),
       (11, 'Torque on a current loop in a magnetic field'),
       (11, 'Moving coil galvanometer'),
       (11, 'Electromagnets'),
       (11, 'The Earths magnetism');

-- Insert SubTopics for Electromagnetic Induction and Alternating Currents
INSERT INTO SubTopics (topicId, subTopicName)
VALUES (12, 'Electromagnetic induction'),
       (12, 'Self-inductance'),
       (12, 'Mutual inductance'),
       (12, 'Alternating current'),
       (12, 'L-C oscillations'),
       (12, 'Transformers');

-- Insert SubTopics for Ray Optics and Optical Instruments
INSERT INTO SubTopics (topicId, subTopicName)
VALUES (13, 'Reflection of light'),
       (13, 'Refraction of light'),
       (13, 'Total internal reflection'),
       (13, 'Optical instruments');

-- Insert SubTopics for Dual Nature of Matter and Radiation
INSERT INTO SubTopics (topicId, subTopicName)
VALUES (14, 'Photoelectric effect'),
       (14, 'De Broglie wavelength'),
       (14, 'Matter waves');

-- Insert SubTopics for Atoms and Nuclei
INSERT INTO SubTopics (topicId, subTopicName)
VALUES (15, 'Rutherfords model of the atom'),
       (15, 'Bohrs model of the atom'),
       (15, 'Quantum mechanical model of the atom'),
       (15, 'X-rays'),
       (15, 'Nuclear physics');

-- Insert SubTopics for Semiconductors
INSERT INTO SubTopics (topicId, subTopicName)
VALUES (16, 'Semiconductors'),
       (16, 'Semiconductor diodes'),
       (16, 'Transistors'),
       (16, 'Integrated circuits');

-- Insert SubTopics for Communication Systems
INSERT INTO SubTopics (topicId, subTopicName)
VALUES (17, 'Basic communication systems'),
       (17, 'Modulation and demodulation'),
       (17, 'Transmission media');



-- For Mathematics 12--

USE BookMyStudySession;

-- Insert Features
-- Insert Topics (for class 10, subject Mathematics)
INSERT INTO Topics (classLevel, subject, topicName)
VALUES (12, 'Mathematics', 'Relations and Functions'),
       (12, 'Mathematics', 'Inverse Trigonometric Functions'),
       (12, 'Mathematics', 'Matrices'),
       (12, 'Mathematics', 'Determinants'),
       (12, 'Mathematics', 'Continuity and Differentiability'),
       (12, 'Mathematics', 'Application of Derivatives'),
       (12, 'Mathematics', 'Integrals'),
       (12, 'Mathematics', 'Application of Integrals'),
       (12, 'Mathematics', 'Differential Equations'),
       (12, 'Mathematics', 'Vectors'),
       (12, 'Mathematics', 'Three-Dimensional Geometry'),
       (12, 'Mathematics', 'Probability');

-- Insert SubTopics for Alcohols
INSERT INTO SubTopics (topicId, subTopicName)
VALUES (18, 'Sets and functions'),
       (18, 'Types of relations'),
       (18, 'Inverse trigonometric functions'),
       (18, 'Composition of functions');

-- Insert SubTopics for Inverse Trigonometric Functions
INSERT INTO SubTopics (topicId, subTopicName)
VALUES (19, 'Definition and range'),
       (19, 'Properties of inverse trigonometric functions'),
       (19, 'Applications of inverse trigonometric functions');

-- Insert SubTopics for Matrices
INSERT INTO SubTopics (topicId, subTopicName)
VALUES (20, 'Types of matrices'),
       (20, 'Matrix operations'),
       (20, 'Determinant of a matrix'),
       (20, 'Inverse of a matrix'),
       (20, 'Applications of matrices');

-- Insert SubTopics for Determinants
INSERT INTO SubTopics (topicId, subTopicName)
VALUES (21, 'Properties of determinants'),
       (21, 'Applications of determinants');

-- Insert SubTopics for Continuity and Differentiability
INSERT INTO SubTopics (topicId, subTopicName)
VALUES (22, 'Continuity'),
       (22, 'Differentiability'),
       (22, 'Derivatives of functions'),
       (22, 'Higher-order derivatives');

-- Insert SubTopics for Application of Derivatives
INSERT INTO SubTopics (topicId, subTopicName)
VALUES (23, 'Rate of change'),
       (23, 'Tangents and normals'),
       (23, 'Maxima and minima'),
       (23, 'Mean value theorem');

-- Insert SubTopics for Integrals
INSERT INTO SubTopics (topicId, subTopicName)
VALUES (24, 'Integration as the inverse process of differentiation'),
       (24, 'Definite and indefinite integrals'),
       (24, 'Methods of integration'),
       (24, 'Area under a curve');

-- Insert SubTopics for Application of Integrals
INSERT INTO SubTopics (topicId, subTopicName)
VALUES (25, 'Area under curves'),
       (25, 'Volume of solids of revolution');

-- Insert SubTopics for Differential Equations
INSERT INTO SubTopics (topicId, subTopicName)
VALUES (26, 'Order and degree of a differential equation'),
       (26, 'Formation of differential equations'),
       (26, 'Methods of solving differential equations');

-- Insert SubTopics for Vectors
INSERT INTO SubTopics (topicId, subTopicName)
VALUES (27, 'Scalar and vector quantities'),
       (27, 'Vector algebra'),
       (27, 'Dot product'),
       (27, 'Cross product'),
       (27, 'Applications of vectors');

-- Insert SubTopics for Three-Dimensional Geometry
INSERT INTO SubTopics (topicId, subTopicName)
VALUES (28, 'Coordinates in three-dimensional space'),
       (28, 'Direction cosines and direction ratios'),
       (28, 'Equation of a line in space'),
       (28, 'Equation of a plane'),
       (28, 'Distance between points and lines');

-- Insert SubTopics for Probability
INSERT INTO SubTopics (topicId, subTopicName)
VALUES (29, 'Probability of an event'),
       (29, 'Conditional probability'),
       (29, 'Bayes theorem'),
       (29, 'Probability distributions');
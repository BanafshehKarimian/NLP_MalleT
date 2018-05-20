# NLP_MalleT

file format for mallet:

instanceName Label F1Name F1Value F2Name F2Value ....
.
.
.

Mallet Commands:
for importing Data:
bin/mallet import-file --input sample-data/vw/train.txt --output labeled.mallet
for output:
bin/mallet train-classifier --input labeled.mallet --training-portion 0.9 --trainer MaxEnt --trainer NaiveBayes

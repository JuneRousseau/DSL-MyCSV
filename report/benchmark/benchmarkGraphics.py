#!/usr/bin/env python3
import csv
import matplotlib.pyplot as plt
from matplotlib import cm
import numpy as np


pathBenchmark="benchmarkMean.csv"
indexSize=0
indexNameTest=1
indexPy_ns=2
indexPy_ms=3
indexSh_ns=4
indexSh_ms=5
indexInterp_ns=6
indexInterp_ms=7
nameTests=["testPrint", "testExportJson", "testSelectNum", "testChangeSep", "testSelectCond", "testIntegration", "testInsert", "testIndexRedundancy", "testFromScratch2", "testNoHeader2", "testRenameField", "testNoHeader", "testFromScratch", "testDelete", "testModify", "testReorder", "testProjection"]
minSize=100
maxSize=1600
sizeStep=100

graphicsPath="plot/"


def parseValue(s):
	try:
		return int(s)
	except:
		try:
			return float(s)
		except:
			return s

def loadCSV(path):
    data=[]
    with open(path, newline='') as csvfile:
    	reader = csv.reader(csvfile, delimiter = ',')
    	header = next(reader)
    	for line in reader:
    		tmprow=[]
    		for ele in line:
    			tmprow.append(parseValue(ele))
    		data.append(tmprow)
    return data


def generateFigByTest(dataTest, testName):
	fig, ax = plt.subplots()
	x=np.array([line[indexSize] for line in dataTest])
	y_python=np.array([line[indexPy_ms] for line in dataTest])
	y_bash=np.array([line[indexSh_ms] for line in dataTest])
	y_interp=np.array([line[indexInterp_ms] for line in dataTest])
	ax.plot(x, y_python, label="python")
	ax.plot(x, y_interp, label="interp")
	ax.plot(x, y_bash, label="bash")
	ax.set_xlabel('Input size (nbLines)')
	ax.set_ylabel("Time (ms)")
	ax.set_title(testName)
	axes = plt.gca()
	axes.set_xlim([minSize,maxSize+(sizeStep/2)])
	axes.set_ylim([0,None])
	plt.legend(bbox_to_anchor=(1,1), loc="best")
	#plt.show()
	fig.savefig(graphicsPath+testName+'.png', bbox_inches='tight')


def generateFigByTestWithoutBash(dataTest, testName):
	fig, ax = plt.subplots()
	x=np.array([line[indexSize] for line in dataTest])
	y_python=np.array([line[indexPy_ms] for line in dataTest])
	y_interp=np.array([line[indexInterp_ms] for line in dataTest])
	ax.plot(x, y_python, label="python")
	ax.plot(x, y_interp, label="interp")
	ax.set_xlabel('Input size (nbLines)')
	ax.set_ylabel("Time (ms)")
	ax.set_title(testName+" (without Bash)")
	axes = plt.gca()
	axes.set_xlim([minSize,maxSize+(sizeStep/2)])
	axes.set_ylim([0,None])
	plt.legend(bbox_to_anchor=(1,1), loc="best")
	#plt.show()
	fig.savefig(graphicsPath+testName+"withoutBash"+'.png', bbox_inches='tight')
	plt.close(fig="all")

def generateFigByVariant(dataTest, variantIndex, variantName):
	fig, ax = plt.subplots()
	x=np.array([i for i in range(minSize,maxSize+sizeStep,sizeStep)])
	#print(dataTest)
	for test in nameTests:
		y=np.array([line[variantIndex] for line in dataTest[test]])
		#print(len(dataTest[test]))
		#print("y:", len(y),"x:", len(x))
		ax.plot(x, y, label=test)
	ax.set_xlabel('Input size (nbLines)')
	ax.set_ylabel("Time (ms)")
	ax.set_title(variantName)
	axes = plt.gca()
	axes.set_xlim([minSize,maxSize+(sizeStep/2)])
	axes.set_ylim([0,None])
	plt.legend(bbox_to_anchor=(1,1), loc="best")
	#ax.legend()
	#plt.show()
	fig.savefig(graphicsPath+variantName+'.png', bbox_inches='tight')
	plt.close(fig="all")

def main():
	data=loadCSV(pathBenchmark)

	dataByTest=dict()
	for test in nameTests:
		dataByTest[test]=[]
		for line in data:
			if line[indexNameTest] == test:#sizeInput
				dataByTest[test].append(line.copy())
		generateFigByTestWithoutBash(dataByTest[test], test)
		generateFigByTest(dataByTest[test], test)
	generateFigByVariant(dataByTest,indexPy_ms ,"python")
	generateFigByVariant(dataByTest,indexSh_ms ,"bash")
	generateFigByVariant(dataByTest,indexInterp_ms ,"interpreter")
	plt.close(fig="all")

	"""
	dataByService=dict()
    for service in [indexPy_ms, indexSh_ms, indexInterp_ms]:
        dataByService[service]=[]
        for line in data:
            if line[indexNameTest] == test:#sizeInput
                dataByTest[test].append(line.copy())
        generateFigByTest(dataByTest[test], test)"""

if __name__ == '__main__':
    main()

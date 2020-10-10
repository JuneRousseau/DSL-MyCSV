#!/bin/sh
		     
pull()
{
    #Copy xtext
    echo "Copy MyCsv.xtext from git repository to workspace"
    cp $gitPath/MyCsv.xtext $workspace/org.xtext.myCsv/src/org/xtext/MyCsv.xtext
    
    #Copy xtend
    echo "Copy generator/ from git repository to workspace"
    cp -r $gitPath/generator/* $workspace/org.xtext.myCsv/src/org/xtext/generator
    
    #Copy examples of mycsv's sources
    echo "Copy examples from git repository to workspace"
    cp -r $gitPath/examples/* $workspace/org.xtext.myCsv.tests/examples

    #Copy directory for JUnit test
    echo "Copy tests from git repository to workspace"
    cp -r $gitPath/tests/* $workspace/org.xtext.myCsv.tests/src/org/xtext/tests
}

commit()
{
    #Copy xtext
    echo "Copy MyCsv.xtext from workspace to git repository"
    cp $workspace/org.xtext.myCsv/src/org/xtext/MyCsv.xtext $gitPath/MyCsv.xtext 

    #Copy xtend
    echo "Copy generator from workspace to git repository"
    cp -r $workspace/org.xtext.myCsv/src/org/xtext/generator/* $gitPath/generator

    #Copy examples of mycsv's sources
    echo "Copy examples from workspace to git repository"
    cp -r $workspace/org.xtext.myCsv.tests/examples/* $gitPath/examples

    #Copy directory for JUnit test
    echo "Copy tests from workspace to git repository"
    cp -r $workspace/org.xtext.myCsv.tests/src/org/xtext/tests/*  $gitPath/tests
}


workspace=/home/bastien/Documents/Cours/DSL/projet-DSL2
gitPath=/home/bastien/Projets/DSL-MyCSV


if [ $# -eq 0 ]
then
    echo "pull or commit argument needed\n"
    exit 1
fi

case $1 in
    "pull") pull;;
    "commit") commit;;
esac

exit 0

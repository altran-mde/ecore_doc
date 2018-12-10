#!/usr/bin/env python3
#######################################################################
# Copyright (c) 2017 ACID - Altran B.V.                               #
# All Rights Reserved                                                 #
#                                                                     #
# MDE-Skeleton is protected by copyright and distributed under       #
# licenses restricting copying, distribution and decompilation.       #
#######################################################################
import os
import sys
from shutil import copy2
from utility import execute

def main():
    try:
     copy2('./settings.xml', '/root/.m2/settings.xml')
    except:
     os.makedirs('/root/.m2')
     copy2('./settings.xml', '/root/.m2/settings.xml')
    print('Copied settings.xml to .m2')

    # Change directory to parent pom

    os.chdir("releng/com.altran.general.emf.ecoredoc.parent")

    maven_command = ['mvn', '-T', '4', '-e', 'install', 'verify']

    exitcode = execute(maven_command, maven_command)
    print("Exit Code: " + str(exitcode))
    if exitcode is not None:
        sys.exit(exitcode)
    else:
        sys.exit(1)


if __name__ == "__main__":
    main()

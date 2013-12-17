#!/usr/bin/env python2.7

from dstack.agent import Agent
import sys
sys.path.insert(0, "/home/darren/src/cloudstack/pyagent/dstack/dist")

if __name__ == '__main__':
    agent = Agent()
    while True:
        line = sys.stdin.readline()
        print "Input:", line
        print agent.execute(line)

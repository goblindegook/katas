#!/usr/bin/env python

from distutils.core import setup, find_packages

setup(name='Katas',
      version='1.0',
      author='Luís Rodrigues',
      author_email='hello@goblindegook.com',
      url='https://github.com/goblindegook/katas/',
      packages=find_packages(exclude=('tests')),
      )

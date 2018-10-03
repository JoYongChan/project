# -*- coding: utf-8 -*-
import numpy as np
import tensorflow as tf
import matplotlib.pyplot as plt
import csv
import pandas as pd
from array import array

# Standardization
def data_standardization(x):
    x_np = np.asarray(x)
    return (x_np - x_np.mean()) / x_np.std()

#데이터값이 너무 작거나 큰 값이 학습을 방해하는것을 방지하고자 값을 0~1로 변환시키는것
def min_max_scaling(x):
    x_np = np.asarray(x)
    return (x_np - x_np.min()) / (x_np.max() - x_np.min() + 1e-7)

# 정규화된 값을 원래의 값으로 되돌린다
# 정규화하기 이전의 org_x값과 되돌리고 싶은 x를 입력하면 역정규화된 값을 리턴한다
def reverse_min_max_scaling(org_x, x):
    org_x_np = np.asarray(org_x)
    x_np = np.asarray(x)
    return (x_np * (org_x_np.max() - org_x_np.min() + 1e-7)) + org_x_np.min()

timesteps = seq_length = 12
data_dim = 1
output_dim = 1

pdr = pd.read_csv('Test_20180912.csv',names=['Date','Sales'],skiprows=1)
del pdr['Date']
#xy = xy[::-1]

#plt.plot(pdr['Sales'])
#print(pdr)
#plt.plot(pdr,linestyle='-', marker='o')
#plt.show()

xy = min_max_scaling(pdr)
x = xy
y = xy[:, [-1]]
#print(x)
#print(y)
dataX = []
dataY = []

for i in range(0, len(y) - seq_length):
    _x = x[i:i + seq_length]
    _y = y[i + seq_length]
    print(i , _x, "->" , _y)
    dataX.append(_x)
    dataY.append(_y)

train_size = int(len(dataX) * 0.7)
test_size = len(dataX) - train_size

trainX, testX = np.array(dataX[0:train_size]),np.array(dataX[train_size:len(dataX)])
trainY, testY = np.array(dataY[0:train_size]),np.array(dataY[train_size:len(dataY)])

X = tf.placeholder(tf.float32, [None, seq_length, data_dim])
Y = tf.placeholder(tf.float32, [None, 1])


cell = tf.contrib.rnn.BasicLSTMCell(num_units=10, state_is_tuple=True, activation=tf.tanh)

outputs , _states = tf.nn.dynamic_rnn(cell, X, dtype=tf.float32)
Y_pred = tf.contrib.layers.fully_connected(outputs[:, -1], output_dim, activation_fn=None)

# cost/loss
loss = tf.reduce_sum(tf.square(Y_pred - Y))
# optimizer
optimizer = tf.train.AdamOptimizer(0.01)
train = optimizer.minimize(loss)

sess = tf.Session()
sess.run(tf.global_variables_initializer())

for i in range(1000):
    _, l = sess.run([train, loss], feed_dict={X: trainX, Y: trainY})
    if (i == 999): #or ((i+1) % 100 == 0):
        print(i, l)

testPredict = sess.run(Y_pred, feed_dict={X: testX})

testPredict = reverse_min_max_scaling(pdr,testPredict)
testY = reverse_min_max_scaling(pdr,testY)

plt.plot(testY)
print(testY)
plt.plot(testPredict)
print(testPredict)

#plt.show()
def result():
    return testPredict
result()
#import sys
#sys.stdout = open('output.txt','w')
FROM node:18-alpine as depencencies
WORKDIR /api
COPY package.json .
RUN npm i
COPY . . 


const express = require('express')
const app = express()
const port = 3000
const mongoose = require('mongoose')


app.use(
  express.urlencoded({
    extended: true,
  }),
)

app.use(express.json())

const personRoutes = require('./routes/personRoutes')

app.use('/person', personRoutes)

app.get('/', (req, res) => {
  res.json({ message: 'Olá❤️' })
})

const DB_USER = 'carolina'
const DB_PASSWORD = 'Senha'

mongoose
.connect(
    `mongodb+srv://${DB_USER}:${DB_PASSWORD}@cluster0.sutn45z.mongodb.net/?appName=Cluster0`,
)
 .then(() => {
    console.log('Conectou ao banco!')
    app.listen(3000)
  })
  .catch((err) => console.log(err))


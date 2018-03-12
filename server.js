"use strict";

const express = require('express');
const session = require('express-session');
const formidable = require('express-formidable');
const models = require('./models');
// const init = require("./init");
// const fs = require("fs");
const bcrypt = require('bcrypt');
require('events').EventEmitter.defaultMaxListeners = Infinity; // To "fix" MaxListenersExceededWarning

const saltRounds = 10;
const app = express();
app.use(express.static(__dirname + '/public'));
app.use(formidable());
app.use(session({
    secret: 'traening might be important',
    resave: false,
    saveUninitialized: false,
    cookie: {
        maxAge: 604800000, // 7 days in milliseconds
        sameSite: 'strict'
    }
}));

function auth(req, res, next) {
    if (req.session && req.session.userId)
        return next();
    else
        return res.sendStatus(401);
}

app.post('/login', async (req, res) => {

});

// app.get('/schemas', auth, async (req, res) => {
app.post('/schemas', async (req, res) => {
    let cycles = await models.Cycle.find();
    if (cycles.length === 0)
        console.log("no cycles");


    let week = {
            squat: [
                [5, 22, "so stronk"],
                [5, 22, "so stronk"],
                [5, 22, "so stronk"],
                [5, 22, "so stronk"],
                [5, 22, "so stronk"],
                [5, 26, "still stronk"]
            ],
            bench: [
                [5, 22, "so stronk"],
                [5, 22, "so stronk"],
                [5, 22, "so stronk"],
                [5, 22, "so stronk"],
                [5, 22, "so stronk"],
                [5, 26, "still stronk"]
            ],
            deadlift: [
                [5, 22, "so stronk"],
                [5, 22, "so stronk"],
                [5, 22, "so stronk"],
                [5, 22, "so stronk"],
                [5, 22, "so stronk"],
                [5, 26, "still stronk"]
            ],
            ohpress: [
                [5, 22, "so stronk"],
                [5, 22, "so stronk"],
                [5, 22, "so stronk"],
                [5, 22, "so stronk"],
                [5, 22, "so stronk"],
                [5, 26, "still stronk"]
            ],
        };


    let testc = {
        owner: "r5hej",
        iteration: 2,
        assistanceExercise: [
            { exercise: "dumbell row", reps: 5, weight: 42 },
            { exercise: "barbel row", reps: 5, weight: 42 },
            ],
        weeks: [week, week, week, week]
    };


    // let c = new models.Cycle(testc, true);
    // await c.save();
    res.send(cycles);
});

app.listen(3000, () => console.log('Example app listening on port 3000!'));


// {
//     "owner"
// :
//     "r5hej",
//         "assistanceExercise"
// :
//     [{
//         "exercise": "dumbell row",
//         "reps": 5,
//         "weight": 42
//     }],
//         "weeks"
// :
//     [{
//         consist of an array with dict for each exercise each week
//             "squat"
// :
//     [
//         [
//             5,
//             22,
//             "so stronk"
//         ],
//         [
//             5,
//             26,
//             "still stronk"
//         ]
//     ]
// }]
// }

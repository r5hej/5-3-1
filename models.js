"use strict";

const mongoose = require('mongoose');

let UserSchema = new mongoose.Schema({
    username: {type: String, required: true, index: { unique: true }},
    password: {type: String, required: true},
    iteration: Number
});

let CycleSchema = new mongoose.Schema({
    owner : String,
    iteration: Number,
    weeks: {type: Array, default: []},
    assistanceExercise: {type: Array, default: []}
});

let User = mongoose.model('User', UserSchema);
let Cycle = mongoose.model('Cycle', CycleSchema);

mongoose.connect('mongodb://localhost/5-3-1');

module.exports = {
    User,
    Cycle
};

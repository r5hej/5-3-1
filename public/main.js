"use strict";

let templates;
let wrapper = document.getElementById('wrapper');
let container, schemeLst, contentBtn;

function renderMain() {
    wrapper.innerHTML = templates.mainView.render();
    container = document.getElementById('content');
    schemeLst = document.getElementById('schemeLst');
    contentBtn = document.getElementById('content-top-btn');

    renderSchemeLst();
    contentBtn.on('click', 'div > div', ev => {
        contentBtn.querySelector('.active').classList.remove('active');
        ev.target.classList.add('active');
        ev.target.dataset.id === "scheme" ? renderScheme() : renderCalculator();
    });

    schemeLst.on('click', 'li', ev => {
        console.log(ev.target);
    });
}

function renderCalculator() {
    container.innerHTML = templates.RMCalculator.render();
    let html = "";
    for (let i = 0; i < 4; i++) {
        html += templates.RMCalculatorRow.render({
            exercise: "squat",
            rm: "86",
            weight: "100",
            reps: "5"
        });
    }
    document.getElementById('calculatorTbody').innerHTML = html;
}

function renderScheme() {
    container.innerHTML = templates.scheme.render();
    let html = "";

    for (let i = 0; i < 5; i++) {
        if (i === 0) {
            html += templates.schemeTableFirstRow.render({exercise: "squat"});
        }
        html += templates.schemeTableRow.render();
    }
    document.getElementById('scheme-tbody').innerHTML = html;
}

function renderSchemeLst() {
    schemeLst.innerHTML = templates.schemeLstItem.render({
        schemeName: "1"
    });
}

function sendRequest(method, url, data, json) {
    return new Promise((res, rej) => {
        json = json === undefined ? true : json;
        let xhr = new XMLHttpRequest();
        xhr.open(method, url, true);

        xhr.onload = ev => {
            if (xhr.readyState === 4 && xhr.status === 200)
                res(json ? JSON.parse(xhr.responseText) : xhr.responseText);
            else
                rej(ev, xhr.statusText);
        };
        xhr.onerror = ev => rej(xhr.statusText);
        xhr.send(data);
    });
}

JsT.get('templates.html', tmpl => {
    templates = tmpl;
    renderMain();
});

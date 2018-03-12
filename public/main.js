"use strict";

let templates;
let wrapper = document.getElementById('wrapper');
let container, schemaLst, contentBtn, cycles;

function renderMain() {
    wrapper.innerHTML = templates.mainView.render();
    container = document.getElementById('content');
    schemaLst = document.getElementById('schemaLst');
    contentBtn = document.getElementById('content-top-btn');

    sendRequest('POST', '/schemas').then(resp => {
        cycles = resp;
        cycles.sort((a, b) => {
            return b.iteration - a.iteration;
        });
        console.log(cycles);
        renderSchemaLst();
    }).catch(() => {
        console.log('could not get schemas');
    });

    contentBtn.on('click', 'div > div', ev => {
        contentBtn.querySelector('.active').classList.remove('active');
        ev.target.classList.add('active');
        ev.target.dataset.id === "schema" ? renderSchema() : renderCalculator();
    });

    schemaLst.on('click', 'li', ev => {
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

function renderSchema() {
    container.innerHTML = templates.schema.render();
    let html = "";
    for (let i = 0; i < 5; i++) {
        if (i === 0) {
            html += templates.schemaTableFirstRow.render({exercise: "squat"});
        }
        html += templates.schemaTableRow.render();
    }
    document.getElementById('schema-tbody').innerHTML = html;
}

function renderSchemaLst() {
    let html = '';
    for (let i = 0; i < cycles.length; i++) {
        html += templates.schemaLstItem.render(cycles[i]);
    }
    schemaLst.innerHTML = html;
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

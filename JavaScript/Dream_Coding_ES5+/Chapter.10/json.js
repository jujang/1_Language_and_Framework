'use strict';
{
    const rabbit=  {
        name: 'oxy',
        color: 'black',
        size: null,
        birthDate: new Date(),
        jump: () => {
            console.log(`${this.name} can jump`);
        },
    };

    let json = JSON.stringify(rabbit);
    console.log(json);

    let json2 = JSON.stringify(rabbit, ['name', 'color', 'size']);
    console.log(json2);

    let json3 = JSON.stringify(rabbit, (key, value) => {
        console.log(`key: ${key}, value: ${value}`);
        return value;
    });
    console.log(json3);
}
# MinetopiaSDB-RESTAPI
Simple json rest api to use with the MinetopiaSDB Minecraft plugin.

## NodeJS Example
Make sure you have node-fetch installed, or use ``npm i node-fetch``

```js
let url = "http://SERVERIP:PORT/api/player/PLAYERNAME";

let response;
try {
  response = await fetch(url, { method: "Get" });
} catch (err) {
	return console.log('The api server could not be reached.');
}

const json = await response.json();
// now you can use json.level or whatever you need from the api in nodejs!
```

## Links
[Discord](https://discord.gg/AvRpCUZ) [MinetopiaSDB](https://minetopiasdb.nl/)

## License
[GNU LGPLv2.1](https://choosealicense.com/licenses/lgpl-2.1/) © [Jazzkuh](https://github.com/Jazzkuh/)

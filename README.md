# MinetopiaSDB-RESTAPI
![Spiget Version](https://img.shields.io/spiget/version/95065?color=red&label=version)
![License](https://img.shields.io/github/license/Jazzkuh/MinetopiaSDB-RESTAPI)
![Spiget Downloads](https://img.shields.io/spiget/downloads/95065)

Simple json rest api to use with the MinetopiaSDB Minecraft plugin. Below you can see what a default response looks like.

```JSON
{
   "success":true,
   "timeDays":0,
   "level":1,
   "prefix":"Zwerver",
   "luckyshards":"0.000",
   "timeHours":0,
   "uuid":"079d6194-3c53-42f8-aac9-8396933b5646",
   "timeSeconds":0,
   "graycoins":0,
   "grayshards":"0.0",
   "fitness":20,
   "goldshards":"0.000",
   "timeMinutes":0
}
```

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

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## Links
[Discord](https://discord.gg/AvRpCUZ) [Spigot](https://www.spigotmc.org/resources/minetopiasdb-restapi.95065/)
[MinetopiaSDB](https://minetopiasdb.nl/)

## License
[GNU LGPLv2.1](https://choosealicense.com/licenses/lgpl-2.1/) © [Jazzkuh](https://github.com/Jazzkuh/)

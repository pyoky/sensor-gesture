from flask import Flask
from flask import request
from flask import jsonify
import json
import pprint

pp = pprint.PrettyPrinter(indent=4)

app = Flask(__name__)

@app.route('/accel', methods = ['GET'])
def accel_data():
    data = request.get_json()
    pp.pprint(data)
    return "OK"


@app.route('/gyro', methods = ['GET'])
def gyro_data():
    print(request.get_json())
    return "OK"

@app.route('/accel', methods = ['GET'])
def magnet_data():
    print(request.get_json())
    return "OK"

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=3000)
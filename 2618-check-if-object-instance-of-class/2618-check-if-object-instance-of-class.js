/**
 * @param {*} obj
 * @param {*} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
    if(obj === null || obj ===undefined) return false
    if(typeof classFunction !== "function") return false
    let proto = Object.getPrototypeOf(obj)
    while(proto !== null){
        if(proto.constructor === classFunction) return true
        proto = Object.getPrototypeOf(proto)

    }
    return false
};

/**
 * checkIfInstanceOf(new Date(), Date); // true
 */
/**
 * @param {Array<Function>} functions
 * @return {Promise<any>}
 */
var promiseAll = function(fns) {
     return new Promise((resolve, reject) => {
    if (!Array.isArray(fns)) return reject(new TypeError('Expected an array'));
    const n = fns.length;
    if (n === 0) return resolve([]);

    const results = new Array(n);
    let remaining = n;
    let settled = false;

    fns.forEach((fn, i) => {
      let p;
      try {
        p = fn();         // start immediately (parallel)
      } catch (err) {     // synchronous throw from fn
        if (!settled) {
          settled = true;
          reject(err);
        }
        return;
      }

      Promise.resolve(p).then(
        (val) => {
          if (settled) return;
          results[i] = val;
          if (--remaining === 0) {
            settled = true;
            resolve(results);
          }
        },
        (err) => {
          if (settled) return;
          settled = true;
          reject(err);    // first rejection wins
        }
      );
    });
  });
};

/**
 * const promise = promiseAll([() => new Promise(res => res(42))])
 * promise.then(console.log); // [42]
 */
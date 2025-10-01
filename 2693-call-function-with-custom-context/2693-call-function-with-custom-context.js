/**
 * @param {Object} context
 * @param {Array} args
 * @return {null|boolean|number|string|Array|Object}
 */
Function.prototype.callPolyfill = function(context, ...args) {
   const ctx = context == null ? globalThis : Object(context);

  const fnKey = Symbol();
  ctx[fnKey] = this;  // 'this' refers to the function being called

  const result = ctx[fnKey](...args);

  delete ctx[fnKey];

  return result;

}

/**
 * function increment() { this.count++; return this.count; }
 * increment.callPolyfill({count: 1}); // 2
 */
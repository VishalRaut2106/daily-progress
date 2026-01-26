
/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
    let cached = {}
    return function(...args) {
        let n = JSON.stringify(args)
        if (n in cached){
             return cached [n]
        }
       else {
        let result = fn.apply(this , args)
        cached [n] = result
        return result
       }
        
    }
}

fn make_vec() -> Vec<i32> {
    let v = vec![1, 2, 3, 4, 5];
}

fn borrow_sum(v: &Vec<i32>) -> i32 {
    v.iter().sum()
}

fn main() {
    let v = make_vec();           
    let sum = borrow_sum(&v);     
    println!("sum = {}", sum);

    {
        let boxed = Box::new(42); // Box allocates on heap
        println!("boxed = {}", boxed);
    } 

    let to_drop = Box::new(vec![0u8; 1_000_000]);
    std::mem::drop(to_drop); 
    println!("dropped large allocation");
}

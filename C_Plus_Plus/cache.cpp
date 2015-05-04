/*
Program 3: Cache Simulator

Author: Kristy Carrion

This program simulates the behavior of an instruction cache. The program will
read data from standard input and produce statistics about a cache 'trace' to
standard output. 

The addresses, one per line. The first three lines of the 
input specifies the number of cache sets, the number of each line
consists of 3 colon separated values representing the memory address (in 
hexadecimal notation),  type of memory access (R or W), and the size, in bytes,
to read or write. Should be able to handle load byte, load halfwood, load word,
and load double word. (Assume word size is 32 bits).
*/

#include <iostream>  
#include <iomanip>   
#include <cstdlib> 
using namespace std;

struct Block
{
    bool valid;  // is this cache valid or empty
    int tag;     // tag of the address
    bool dirty;  // if the data is dirty(write) 
    
    Block* next;    // point to next block in the set
};

class CacheSet
{
public:
    // constructor and destructor
    CacheSet(int nway);
    ~CacheSet();
    
    // visit the address, read/write, return number of mem refs
    int visit(int tag, bool write);

private:
    int numBlocks;
    Block* first;   // first is the block least recently used 
    Block* last;    
};

// This class will store the cache and process input 
class CacheSys
{
public:
    // Constructor with parameters
    CacheSys(int nset, int nway, int nbyte);
    
    // destructor
    ~CacheSys();
    
    // start to process
    void start();

private:
    // Determine if n is power of 2
    bool powerOf2(int n);
    
    int numSets;
    int numWay;
    int numBytes;
    
    CacheSet** csets;   // cache sets
};

int main()
{
    char buffer[200];    // buffer to read input string
    int numSets = 0;     // number of sets
    int numWay = 0;      // number of element in a set
    int numBytes = 0;    // the size of a cache line 
    
    // read 3 arguments
    cin.getline(buffer, sizeof(buffer), ':');
    cin >> numSets;    
    cin.getline(buffer, sizeof(buffer));
                                         
    cin.getline(buffer, sizeof(buffer), ':');
    cin >> numWay;    
    cin.getline(buffer, sizeof(buffer));
                                          
    cin.getline(buffer, sizeof(buffer), ':');
    cin >> numBytes;    
    cin.getline(buffer, sizeof(buffer));
    
    CacheSys sys(numSets, numWay, numBytes);
    sys.start();
    
    return 0;
}

CacheSet::CacheSet(int nway)
{
    numBlocks = nway;
    first = NULL;
    last = NULL;
    
    // Allocate blocks
    for (int i = 0; i < nway; i++)
    {
        Block* blk = new Block();
        blk->valid = false;
        blk->next = first;
        first = blk;
        
        if (last == NULL)
            last = blk;            
    }
}

CacheSet::~CacheSet()
{
    // Delete all blocks
    while (first != NULL)
    {
        Block* blk = first;
        first = first->next;
        delete blk;
    }
}
    
    
// visit the address, read/write, return number of mem refs
int CacheSet::visit(int tag, bool write)
{      
    Block* prev = NULL;
    Block* p = first;
    
    // find the tag
    while (p != NULL)
    {
        if (p->valid && p->tag == tag)
            break;
        
        prev = p;
        p = p->next;    
    }
    
    // hit
    if (p != NULL)
    {
        if (write)
            p->dirty = true;
    
        // recently visited, move p to last
        if (p != last)
        {
            if (prev == NULL)
                first = p->next;
            else
                prev->next = p->next; 
            last->next = p;
            last = p;
            last->next = NULL;
        }
        return 0;
    }
    
    // missed, use first block(least recently used)
    int refs = 1;
    if (first->valid && first->dirty)  // write back
        refs++;

    // move p to last        
    p = first;
    if (first->next != NULL)
    {
        first = first->next;
        last->next = p;
        last = p;
        last->next = NULL;
    }
    
    p->valid = true;
    p->tag = tag;
    if (write)
        p->dirty = true;
    
    return refs;
}


///////////////////////////////////////////////////////////////////////////
      
// Constructor with parameters
CacheSys::CacheSys(int nset, int nway, int nbyte)
{
    numSets = nset;
    numWay = nway;
    numBytes = nbyte;
    
    if (!powerOf2(numSets) || numSets > 8 * 1024)
    {
        cout << "Invalid number of sets" << endl;
        exit(0);
    }
    if (!powerOf2(numBytes) || numBytes < 4)
    {   
        cout << "Invalid line size" << endl;
        exit(0);
    }
    if (numWay <= 0 || numWay > 8)
    { 
        cout << "Invalid associativity level" << endl;
        exit(0);
    }
    
    // create the cache sets
    csets = new CacheSet*[numSets];
    for (int i = 0; i < numSets; i++)
        csets[i] = new CacheSet(nway);    
    
    // output the conifguration
    cout << "Cache Configuration" << endl << endl;
    cout << "   " << numSets << " " << numWay 
         << "-way set associative entries" << endl;
    cout << "   of line size " << numBytes << " bytes" << endl;
    cout << endl << endl;
    cout << "Results for Each Reference" << endl << endl;
}

CacheSys::~CacheSys()
{
    for (int i = 0; i < numSets; i++)
        delete csets[i];
    delete[] csets;
}
    
// start to process
void CacheSys::start()
{
    int address;  // address to access
    char access;  // R=read W=write
    int bytes;    // bytes to access
    char colon;   // character ':'
    
    int tag;      // tag of the address
    int index;    // index of the address
    int offset;   // offset of the address
    
    int totalHits = 0;
    int totalAccesses = 0;
    
    cout << "Access Address    Tag   Index Offset Result Memrefs" << endl;
    cout << "------ -------- ------- ----- ------ ------ -------" << endl;
    
    while (!cin.eof())
    {
        cin >> hex >> address;  // hex address
        cin >> colon >> access >> colon;
        cin >> dec >> bytes;    // decimal bytes   
      
        // end of file
        if (cin.fail())
            break;
            
        if (access == 'R')
            cout << "  read";
        else
            cout << " write";
            
        offset = address % numBytes;
        index  = (address / numBytes) % numSets;
        tag    = (address / numBytes) / numSets; 
            
        cout << hex << setw(9) << address;
        cout << hex << setw(8) << tag;
        cout << dec << setw(6) << index; 
        cout << dec << setw(7) << offset;
        
        // visit the address
        int totalRefs = csets[index]->visit(tag, access == 'W');
        
        // start address of the block
        int startAddr = address - offset;
        
        // is not aligned , need to visit multiple times
        while (startAddr + numBytes < address + bytes)
        {                                       
            startAddr += numBytes;    
            index = (startAddr / numBytes) % numSets;
            totalRefs += csets[index]->visit(tag, access == 'W');
        }
        
        
        totalAccesses++;
        if (totalRefs > 0)
        {
            cout << "   miss";
        }
        else
        {                     
            totalHits++;
            cout << "    hit";
        } 
        cout << dec << setw(8) << totalRefs << endl;
    }
    
    // output Statistics
    cout << endl << endl << "Simulation Summary Statistics" << endl;
    cout << "-----------------------------" << endl;
    cout << "Total hits       : " << totalHits << endl;   
    cout << "Total misses     : " << (totalAccesses - totalHits) << endl; 
    cout << "Total accesses   : " << totalAccesses << endl;       
    cout << "Hit ratio        : " << (totalHits/(double)totalAccesses) << endl;
    cout << "Miss ratio       : " << (1-totalHits/(double)totalAccesses)
         << endl;
} 

// Determine if n is power of 2
bool CacheSys::powerOf2(int n)
{
    while (n != 1)
    {
        if (n % 2 == 1)
            return false;
        n = n / 2;
    }
    return true;
}
